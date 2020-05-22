Map<K,V> lhm =
int desiredSize = 
for(Iterator iter = lhm.keySet().iterator();iter.hasNext()) {
   if(lhm.size() <= desiredSize) break;
   iter.remove();
}