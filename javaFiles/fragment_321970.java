<%
// Create an ArrayList with test data
ArrayList list = new ArrayList();
Map person1 = new HashMap();
person1.put("name", "A");
person1.put("lastname", "A1";
list.add(person1);
Map person2 = new HashMap();
person2.put("name", "B");
person2.put("lastname", "B1");
list.add(person2);
Map person3 = new HashMap();
person3.put("name", "C");
person3.put("lastname", "");
list.add(person3);
pageContext.setAttribute("persons", list);