public static void main(String[] args) {

    String[] strings = {"one", "one", "one", "one", "one", "one", "one", "one", "one", "one", "one", "one"
            , "two", "two", "two", "two", "two", "two", "two", "two", "two", "two", "two", "two", "two", "two", "two"
            , "three", "three", "three", "three", "three", "three", "three", "three", "three", "three", "three"
            , "four", "four", "four", "four", "four", "four", "four", "four", "four", "four"
            , "five", "five", "five", "five", "five", "five"
            , "six", "six", "six", "six", "six", "six", "six", "six", "six"
            , "seven", "seven", "seven", "seven", "seven", "seven", "seven", "seven"
            , "eight", "eight", "eight", "eight", "eight", "eight"
            , "nine", "nine", "nine", "nine", "nine", "nine", "nine", "nine", "nine"
            , "ten", "ten", "ten", "ten", "ten", "ten", "ten", "ten", "ten"};

    Map<String,Integer> itemMap=new LinkedHashMap<>();
    for (String item:strings){
        if(!itemMap.containsKey(item)){
            itemMap.put(item,1);
        }else{
            itemMap.put(item, itemMap.get(item)+1);
        }
    }

    for(Map.Entry<String, Integer> mapEntry:itemMap.entrySet()){
        if(mapEntry.getValue()>1){
            System.out.println(mapEntry.getKey()+"\n"+mapEntry.getKey());
        }
    }
}