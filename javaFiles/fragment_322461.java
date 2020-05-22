String currentLine = "<%=Pages.getString(\\\"MY_HEADER\\\")%>"; 
Pattern pattern = Pattern.compile("<%=Pages\\.getString\\(\\\\\"([^\\\\]*)"); 
Matcher matcher = pattern.matcher(currentLine); 
while(matcher.find()) {
    System.out.println(matcher.group(1).toString()); 
}