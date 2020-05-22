Map<String,List<Object>> principalMap = new HashMap<String,List<Object>>();

for (Object principalEntityInstance : principalEntityInstances) {
   List<String> keys = getKeysFor(principalEntityInstance);
   for(String key : keys) {
       List<Object> l = principalMap.get(key);
       if(l==null) {
           l = new ArrayList<Object>();
           principalMap.put(key,l);
       }
       l.add(principalEntityInstance);
   }
}