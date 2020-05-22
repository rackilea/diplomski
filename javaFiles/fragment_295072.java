Matcher m = replacer.matcher(in);
StringBuilder strb = new StringBuilder(in.length());//ensuring capacity

while(m.find()){
    m.appendReplacement(strb,"");//this writes out what came in between matching words
    //m.group() returns what was matched
    for(int i=m.start();i<m.end();i++)
        strb.append("*");
}
m.appendTail(strb);
return strb.toString;