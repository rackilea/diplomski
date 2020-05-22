List<String> test= Arrays.asList("a", "c", "g","t", "aa","ac","ag","at","aaa","aac","aag","aat","aca","acc","aaaa");
HashMap<String, Integer> encodeValue = new HashMap<String,Integer>();
int i = 1;
for(String value : test){
    if(!encodeValue.containsKey(value)){
        encodeValue.put(value, new Integer(i));
        i++;
        }
}
System.out.println(Arrays.asList(encodeValue));