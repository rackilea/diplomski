String data = "\"1\",\"10411721\",\"MikeTison\",\"08/11/2009\",\"21/11/2009\",\"2800.00\",\"002934538\",\"051\",\"New York\",\"10411720-002\",\".\\Images\\b.jpg\",\".\\RTF\\b.rtf\"";

Pattern p = Pattern.compile("\"([^\"]+)\"");
Matcher m = p.matcher(data);
while(m.find()){
    System.out.println(m.group(1));
}