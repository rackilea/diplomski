for(String key : new String[] { "type", "name" }) {
   int compare = m1.get(key).toString().compareTo(m2.get(key).toString());
   if(compare != 0) {
      return compare;
   }
}
return 0;