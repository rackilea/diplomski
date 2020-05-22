Document doc = new Document("String","Aeroplane").append("int", 20);

String s1 = doc.getString("String");
String s2 = doc.getString("string");
System.out.println("s1="+s1+" and s2="+s2);

int i1 = doc.getInteger("int");
int i2 = doc.getInteger("Int"); //throws NullPointerException
System.out.println("i1="+i1+" and i2="+i2);