String str = "aaaa#include(soap1.xml)bbbb#include(soap2.xml)cccc";
String p = "#include\\(([^)]*)\\)";
Pattern ptrn = Pattern.compile(p);
Matcher matcher = ptrn.matcher(str);
List<String> arr = new ArrayList<String>();
while (matcher.find()) {
    arr.add(matcher.group(1));       // Get the Group 1 value, file name
}
System.out.println(arr); // => [soap1.xml, soap2.xml]
System.out.println(str.replaceAll(p, "")); // => aaaabbbbcccc