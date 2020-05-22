StringBuffer sb= new StringBuffer();
while (tagMatch.find()) {
    //this will add text to buffer with replaced matched part
    tagMatch.appendReplacement(sb, parseTag(tagMatch.group(1)));
}
tagMatch.appendTail(sb);//to add rest of input after last replacement

String result = sb.toString();
System.out.println(result);