Map<String, String> newMap=new HashMap<>(); //as of Java 7
BigDecimal value1=null;
for (Map.Entry<String,Object> me : origMap.entrySet()) {  
  if(otherMap.containsKey( me.getKey() )) {
    Object otherValue = otherMap.get(me.getKey());
    Object origValue =  origMap.get(me.getKey());
    String key = otherValue != null ? otherValue.toString() : null; //note: this might cause problems if null keys are not allowed
    String value = origValue != null ? origValue.toString() : null;
    newMap.put(key, value);
  }else {
    Object origValue =  origMap.get(me.getKey());
    if( origValue != null ) {
      value1=value1.add(new BigDecimal( origValue.toString())); //note: this might cause NumberFormatException etc. if the value does not represent a parseable number
    }
  }

  queryMap.put("others", value1);
}