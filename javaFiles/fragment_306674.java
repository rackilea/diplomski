int contentLength = 0;
while( sc.hasNext() ){
    String aLine = sc.next();
    contentLength += aLine.length();
    // process the line would be a good idea here, perhaps appending a StringBuffer
}
System.out.prinlnt(contentLength);