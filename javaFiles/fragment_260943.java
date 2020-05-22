@Test
public void testLogMethodStartDebug() throws Exception {
    String var1 = "var1";
    String var2 = "var2";
    String var3 = "var3";
    Object[] object = new Object[] {"var4"}; 

    BaseComponent baseComponent = new BaseComponent();
    baseComponent.setLoggingHandler(new TestLoggingHandler());
    baseComponent.getLoggingHandler().setGeneralDebugEnabled(true);

    ILoggable loggable = new ServiceContext();

    baseComponent.logMethodEndDebug(loggable, var1, var2, var3, object);

    assertTrue(baseComponent.getLoggingHandler().isGeneralDebugEnabled());
}