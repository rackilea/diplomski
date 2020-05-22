String input = "abcdef";
Pattern p = Pattern.compile("(?=(ab)|(bc)|(de)|(f))");
Matcher m = p.matcher(input);
while (m.find()){
    for (int i=1; i<=m.groupCount(); i++){
        if (m.group(i)!=null) 
            System.out.println("group ("+i+") -> "+m.group(i));
    }
}