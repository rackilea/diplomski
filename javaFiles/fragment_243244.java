package io.mikael.poc;

import com.google.common.io.CharStreams;
import org.junit.*;
import org.postgresql.PGConnection;
import org.postgresql.copy.CopyManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CopyTest {

    private Reader reader;

    private Connection connection;

    private CopyManager copyManager;

    private static final String CREATE_TYPE = "CREATE TYPE address AS (ip inet, port int)";

    private static final String CREATE_TABLE = "CREATE TABLE my_table (addresses  address[] NULL)";

    private String loadCsvFromFile(final String fileName) throws IOException {
        try (InputStream is = getClass().getResourceAsStream(fileName)) {
            return CharStreams.toString(new InputStreamReader(is, UTF_8));
        }
    }

    @ClassRule
    public static PostgreSQLContainer db = new PostgreSQLContainer("postgres:10-alpine");

    @BeforeClass
    public static void beforeClass() throws Exception {
        Class.forName("org.postgresql.Driver");
    }

    @Before
    public void before() throws Exception {
        String input = loadCsvFromFile("/data_01.csv");
        reader = new StringReader(input);

        connection = DriverManager.getConnection(db.getJdbcUrl(), db.getUsername(), db.getPassword());
        copyManager = connection.unwrap(PGConnection.class).getCopyAPI();

        connection.setAutoCommit(false);
        connection.beginRequest();

        connection.prepareCall(CREATE_TYPE).execute();
        connection.prepareCall(CREATE_TABLE).execute();
    }

    @After
    public void after() throws Exception {
        connection.rollback();
    }

    @Test
    public void copyTest01() throws Exception {
        copyManager.copyIn("COPY my_table (addresses) FROM STDIN WITH CSV QUOTE ''''", reader);

        final StringWriter writer = new StringWriter();
        copyManager.copyOut("COPY my_table TO STDOUT WITH CSV", writer);
        System.out.printf("roundtrip:%n%s%n", writer.toString());

        final ResultSet rs = connection.prepareStatement(
                "SELECT array_to_json(array_agg(t)) FROM (SELECT addresses FROM my_table) t")
                .executeQuery();
        rs.next();
        System.out.printf("json:%n%s%n", rs.getString(1));
    }

}