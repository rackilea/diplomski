public class App {

    public static void main( String[] args ) {

        ApplicationContext context =  new ClassPathXmlApplicationContext("web.xml");
        JdbcTemplate jdbcTemplateObject = context.getBean(JdbcTemplate.class);
        String SQL = "insert into issues(issue,status,comment) values (?, ?, ?)";
        jdbcTemplateObject.update( SQL, new Object[]{"Zara", "test", "123"} );
        System.out.println( "Hello World!" );
    }
}