String s = "$Country$$Country$\nWAN$Country$/$Country$\n$Country$/29\n$Country$/$Country$\n\"$fdfsrwdrdgf$1$asffdjhk\""; 
Pattern pattern = Pattern.compile("\"[^\"\\\\]*(?:\\\\.[^\\\\\"]*)*\"|(\\$[^$]*\\$)"); 
Matcher matcher = pattern.matcher(s);
List<String> res = new ArrayList<>();
while (matcher.find()){
    if (matcher.group(1) != null) {
        res.add(matcher.group(1)); 
        //                    ^  - Get Group 1 only! 
    }
} 
System.out.println(res);
// => [$Country$, $Country$, $Country$, $Country$, $Country$, $Country$, $Country$]