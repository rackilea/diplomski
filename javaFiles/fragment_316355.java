List attributes = current.getAttributes();
Iterator it = attributes.iterator();
while (it.hasNext()) {
  Attribute att = (Attribute)it.next();
  System.out.println(att.getName()); // att1
  System.out.println(att.getValue()); // value1
}