BufferedReader r = new BufferedReader( new FileReader( "testing.txt" ) );
String s = "", line = null;
while ((line = r.readLine()) != null) {
    s += line;
}
System.out.print(s);