DataSource ds;

@Before
public void setUp() throws NamingException {
    this.ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/nameofmyjdbcresource");
}