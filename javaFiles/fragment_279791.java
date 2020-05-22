Set<Entry<String, String>> set = sections.entrySet();       
Iterator<Entry<String, String>> iter = set.iterator();
boolean foundName = false;
String nextSection;
while(iter.hasNext()){
    Map.Entry<String,String> me = iter.next();
    if (foundName == true){
        nextSection = me.getValue();
        nextSection = nextSection.toString();
        break;
    }