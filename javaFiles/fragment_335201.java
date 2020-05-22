@Test
public void test2(){
  PropertyConfigurator.configure("/....web-inf/classes/log4j.properties");
  Logger log = Logger.getLogger(GuestBookExample.class.getName());
  assertEquals(Level.WARN, log.getLevel());
}