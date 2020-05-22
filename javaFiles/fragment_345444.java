List<String> keys = Arrays.asList("one", "two", "three'");


for(String key: keys){
    if(!left.get(key).equals(right.get(key))){
       //do something with difference
    }
};