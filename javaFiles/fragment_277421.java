public void updateEmoticonMap(Map<String,Integer> countMap, String emoticon){
    Integer count = countMap.get(emoticon);
    if(count == null){
        count = 0;
    }
    count++;
    countMap.put(emoticon,count);
}