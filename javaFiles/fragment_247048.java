// Code is for illustration purpose only, I haven't compiled it!!!

public class Person {
    private String name;
    private int age;
    // ...

   public String serializeToXml() {
       StringBuilder xml = new StringBuilder();   
       xml.append("<person>");
       xml.append("<attribute name=\"age\" type=\"int\">").append(age);
       xml.append("</attribute>");
       xml.append("<attribute name=\"name\" type=\"string\">").append(name);
       xml.append("</attribute>"); 
       xml.append("</person>");
       return xml.toString(); 
}