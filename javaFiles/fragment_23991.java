String pattern = "TKK_\\d+";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher("http://somewhere.com/core?item=TKK_43123");
if (m.find()){
    System.out.println(m.group(0)); 
} 
// => TKK_43123