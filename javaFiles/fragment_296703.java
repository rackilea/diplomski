public class TestFreeMarkerTemplating {

Configuration cfg = new Configuration();
StringTemplateLoader stringLoader = new StringTemplateLoader();
{ cfg.setTemplateLoader(stringLoader);
cfg.setObjectWrapper(new BeansWrapper()); }

@Test
public void testTestableMacros() throws TemplateException, IOException{
    stringLoader.putTemplate("root", "<#macro user testPojo>Welcome ${testPojo.user}. <@subPojo sub/></#macro><#macro subPojo sub>Sub ${sub.user}!</#macro>");
    stringLoader.putTemplate("testPojoTemplate", "<#import \"root\" as w><@w.user .data_model/>");
    stringLoader.putTemplate("testSubPojoTemplate", "<#import \"root\" as w><@w.subPojo .data_model/>");
    assertTemplateAndBeanYield("root", new TestPojo(), "");
    assertTemplateAndBeanYield("testPojoTemplate", new TestPojo(), "Welcome Andy. Sub Bill!");
    assertTemplateAndBeanYield("testSubPojoTemplate", new SubPojo(), "Sub Bill!");

}

public void assertTemplateAndBeanYield(String templateName, Object bean, String expectedOutput) throws IOException, TemplateException{
    Template temp = cfg.getTemplate(templateName);
    StringWriter out = new StringWriter();
    temp.process(bean, out);

    assertEquals(expectedOutput, out.toString());
}

public static class TestPojo {
    private final String user = "Andy";
    private final SubPojo sub = new SubPojo();

    public String getUser() { return user; }
    public SubPojo getSub() { return sub; }
}

public static class SubPojo {
    private final String user = "Bill";

    public String getUser() { return user; }
}
}