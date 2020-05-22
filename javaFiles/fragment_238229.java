String s1=null;
String s2="";
System.out.println(s1);
System.out.println(s2);
s1=s1+"jay";
s2=s2+"jay";

// compiler convert these lines like this,
// s1 = (new StringBuilder()).append((String)null).append("jay").toString();
// s2 = (new StringBuilder()).append((String)"").append("jay").toString();

System.out.println(s1);
System.out.println(s2);