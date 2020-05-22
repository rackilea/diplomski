// your input
String name1 = "MemorySection[path='rr', root='YamlCofiguration']=1";
// this string indicates the start of the path
String start = "path='";
// where the path starts
int pathStart = name1.indexOf(start)+start.length();
// where the path ends
int pathEnd = name1.substring(pathStart).indexOf("'") + pathStart;
// get the path
System.out.println( name1.substring(pathStart, pathEnd) ); // prints: rr