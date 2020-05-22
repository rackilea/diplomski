ByteArrayOutputStream baos = new ByteArrayOutputStream();
PrintStream ps = new PrintStream(baos);
PrintStream old = System.out;
String[] str= new String[10];

System.setOut(ps);

for(int x=0;x<str.length;x++){
ps.println("Test: "+x);
str[x] = baos.toString();
baos.reset();
}
System.out.flush();
System.setOut(old);
for(int x=0;x<str.length;x++){
System.out.println(str[x]);
}