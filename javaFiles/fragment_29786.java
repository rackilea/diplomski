package test;

import test.IUnsafeIn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;

import core.SqlBaseTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public final class InsertVsBatchInsertTest extends SqlBaseTest {

    private static final int ITERATION_COUNT = 3000;

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS ttt1 (c1 INTEGER, c2 FLOAT, c3 VARCHAR(5)) ENGINE = InnoDB";
    private static final String DROP_TABLE_QUERY = "DROP TABLE ttt1";
    private static final String CLEAR_TABLE_QUERY = "DELETE FROM ttt1";

    private static void withinTimer(String name, Runnable runnable) {
        final long start = currentTimeMillis();
        runnable.run();
        logStdOutF("%20s: %d ms", name, currentTimeMillis() - start);
    }

    @BeforeSuite
    public void createTable() {
        runWithConnection(new IUnsafeIn<Connection, SQLException>() {
            @Override
            public void handle(Connection connection) throws SQLException {
                final PreparedStatement statement = connection.prepareStatement(CREATE_TABLE_QUERY);
                statement.execute();
                statement.close();
            }
        });
    }

    @AfterSuite
    public void dropTable() {
        runWithConnection(new IUnsafeIn<Connection, SQLException>() {
            @Override
            public void handle(Connection connection) throws SQLException {
                final PreparedStatement statement = connection.prepareStatement(DROP_TABLE_QUERY);
                statement.execute();
                statement.close();
            }
        });
    }

    @BeforeTest
    public void clearTestTable() {
        runWithConnection(new IUnsafeIn<Connection, SQLException>() {
            @Override
            public void handle(Connection connection) throws SQLException {
                final PreparedStatement statement = connection.prepareStatement(CLEAR_TABLE_QUERY);
                statement.execute();
                statement.close();
            }
        });
    }

    @Test
    public void run1SingleInserts() {
        withinTimer("Single inserts", new Runnable() {
            @Override
            public void run() {
                runWithConnection(new IUnsafeIn<Connection, SQLException>() {
                    @Override
                    public void handle(Connection connection) throws SQLException {
                        for ( int i = 0; i < ITERATION_COUNT; i++ ) {
                            final PreparedStatement statement = connection.prepareStatement("INSERT INTO ttt1 (c1, c2, c3) VALUES (?, ?, ?)");
                            statement.setInt(1, i);
                            statement.setFloat(2, i);
                            statement.setString(3, valueOf(i));
                            statement.execute();
                            statement.close();
                        }
                    }
                });
            }
        });
    }

    @Test
    public void run2BatchInsert() {
        withinTimer("Batch insert", new Runnable() {
            @Override
            public void run() {
                runWithConnection(new IUnsafeIn<Connection, SQLException>() {
                    @Override
                    public void handle(Connection connection) throws SQLException {
                        final PreparedStatement statement = connection.prepareStatement("INSERT INTO ttt1 (c1, c2, c3) VALUES (?, ?, ?)");
                        for ( int i = 0; i < ITERATION_COUNT; i++ ) {
                            statement.setInt(1, i);
                            statement.setFloat(2, i);
                            statement.setString(3, valueOf(i));
                            statement.addBatch();
                        }
                        statement.executeBatch();
                        statement.close();
                    }
                });
            }
        });
    }

    @Test
    public void run3DirtyBulkInsert() {
        withinTimer("Dirty bulk insert", new Runnable() {
            @Override
            public void run() {
                runWithConnection(new IUnsafeIn<Connection, SQLException>() {
                    @Override
                    public void handle(Connection connection) throws SQLException {
                        final StringBuilder builder = new StringBuilder("INSERT INTO ttt1 (c1, c2, c3) VALUES ");
                        for ( int i = 0; i < ITERATION_COUNT; i++ ) {
                            if ( i != 0 ) {
                                builder.append(",");
                            }
                            builder.append(format("(%s, %s, '%s')", i, i, i));
                        }
                        final String query = builder.toString();
                        final PreparedStatement statement = connection.prepareStatement(query);
                        statement.execute();
                        statement.close();
                    }
                });
            }
        });
    }

    @Test
    public void run4SafeBulkInsert() {
        withinTimer("Safe bulk insert", new Runnable() {
            @Override
            public void run() {
                runWithConnection(new IUnsafeIn<Connection, SQLException>() {
                    private String getInsertPlaceholders(int placeholderCount) {
                        final StringBuilder builder = new StringBuilder("(");
                        for ( int i = 0; i < placeholderCount; i++ ) {
                            if ( i != 0 ) {
                                builder.append(",");
                            }
                            builder.append("?");
                        }
                        return builder.append(")").toString();
                    }

                    @SuppressWarnings("AssignmentToForLoopParameter")
                    @Override
                    public void handle(Connection connection) throws SQLException {
                        final int columnCount = 3;
                        final StringBuilder builder = new StringBuilder("INSERT INTO ttt1 (c1, c2, c3) VALUES ");
                        final String placeholders = getInsertPlaceholders(columnCount);
                        for ( int i = 0; i < ITERATION_COUNT; i++ ) {
                            if ( i != 0 ) {
                                builder.append(",");
                            }
                            builder.append(placeholders);
                        }
                        final int maxParameterIndex = ITERATION_COUNT * columnCount;
                        final String query = builder.toString();
                        final PreparedStatement statement = connection.prepareStatement(query);
                        int valueIndex = 0;
                        for ( int parameterIndex = 1; parameterIndex <= maxParameterIndex; valueIndex++ ) {
                            statement.setObject(parameterIndex++, valueIndex);
                            statement.setObject(parameterIndex++, valueIndex);
                            statement.setObject(parameterIndex++, valueIndex);
                        }
                        statement.execute();
                        statement.close();
                    }
                });
            }
        });
    }

}