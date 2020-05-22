StringBuffer tr = new StringBuffer();
while (!myWorkLine.substring(0,1).equals("<")) {
    myTag = myWorkLine.substring(0,myWorkLine.indexOf("="));
    myWorkLine = myWorkLine.substring(myWorkLine.indexOf("=")+2);
    myValue = myWorkLine.substring(0,myWorkLine.indexOf("\""));
    myWorkLine = myWorkLine.substring(myWorkLine.indexOf("\"")+2);
    tr.append(myTag + " " + myValue).append(",");
    if (myWorkLine.substring(0,myWorkLine.indexOf("\">")).indexOf(">") > 0)
        break;
}
if (tr.length() > 0) {
    tr.deleteCharAt(tr.length()-1);  // get rid of last comma
}
uprs.updateString("Tr",tr.toString());