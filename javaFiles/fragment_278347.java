[...]
@Before
public void before() throws Exception {
  System.setProperty("openejb.logger.external", "true");
  InitialContext ctx = new InitialContext();
}
[...]