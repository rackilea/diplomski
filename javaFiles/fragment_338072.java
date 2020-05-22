List<Long> newList = new ArrayList<Long>();
for(Long l : target) {       
   if(newList.isEmpty() || !l.equals(newList.get(newList.size()-1))) {
      newList.add(l); 
   }
}