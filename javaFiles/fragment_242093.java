<%=Session session = request.getSession();
Enumeration attributeNames = session.getAttributeNames();
while (attributeNames.hasMoreElements()) {
String name = attributeNames.nextElement();
String value = session.getAttribute(name);
System.out.println(name + "=" + value);}%>