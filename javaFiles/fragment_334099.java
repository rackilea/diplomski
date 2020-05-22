List<Object> movlist=movquery.list();
String s = "[";
for(Object o:movlist){
   Object[] array = (Object[]) o;
   s += "{\"channelId\":\""+array[0]+"\",\"channelName\":\""+array[1]+"\",\"channelLanguage\":\""+array[2]+"\",},";
}
s += "]";