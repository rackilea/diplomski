String s = "    *Some text*   *Another text* *Yet another text*        **last text**";
Pattern pattern = Pattern.compile("\\B\\*\\b([^*]+)\\b\\*\\B");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}