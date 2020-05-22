Map<String, Integer>amap=new HashMap<String,Integer>(); 
String[] splt=s.split(":");
try {
    for (int i = 0; i <= pair.length; i +=2) {
    amap.put(pair[i].trim(), Integer.parseInt(pair[(1 + i)].trim()));
}
} catch (Exception e) {

}