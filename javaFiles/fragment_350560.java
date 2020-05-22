String s = "I `need` to match a ``word`` from a ```sentence`` Which `lies`` between `backquotes```` and this ``should```` also match and ```more``` than ```three```````` quotes ```````not```  matched";
Pattern pattern = Pattern.compile("(?<!`)`{1,2}\\b(?!`)(.*?)\\b`+");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}