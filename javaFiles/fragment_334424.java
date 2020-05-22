Pattern h2Pattern = Pattern.compile("<h2.*?>");
Matcher m=p.matcher(replaceAllTags);
StringBuffer sb=new StringBuffer();
for(Iterator<String> it=myAnchorLinks.iterator(); it.hasNext() && m.find(); ) {
  m.appendReplacement(sb, "<h2 id="+it.next()+">");
}
m.appendTail(sb);
replaceAllTags=sb.toString();