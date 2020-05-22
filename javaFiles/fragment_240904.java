@RunWith(Arquillian.class)
public class MyTest {

    @Deployment
    public static WebArchive createDeployment() throws Exception {
        return ShrinkWrap.create(WebArchive.class)
            .addAsResource("META-INF/init-schema.sql")  // create table ...
            .addAsResource("META-INF/testdata.sql")  // insert into ...
            .addAsResource("META-INF/drop-schema.sql") // drop table ...
            .addAsResource("META-INF/persistence.xml");
            // and maybe more ...
    }

}