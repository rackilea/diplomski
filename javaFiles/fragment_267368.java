import java.lang.reflect.Method;
...
Method m = product.getClass().getMethod("setName",String.class);
XmlElement a = m.getAnnotation(XmlElement.class);
String nameValue = a.name();
System.out.println(nameValue);