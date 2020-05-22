String tag=m.group();
String tagName=(String) tag.subSequence(1,tag.length()-1);
int cI=tag.indexOf(':');
String data="";
if (cI!=-1) {
    tagName=(String) tag.subSequence(1,cI);
    int numChar=Integer.parseInt((String) tag.subSequence(cI+1,tag.length()-1));
    int end=m.end();
    data = (String) line.subSequence(end,end+numChar);
}