private void postorder(BSTNode r)
 {
     String key;
     if (r != null)
     {
         key = r.getData();
         if(map.containsKey(key)){
            Integer value = (Integer)map.get(key);
            map.put(key, ++value);
         }
         postorder(r.getLeft(),file);
         postorder(r.getRight(),file);

         System.out.println(r.getData() +", " + counter); 
     }
 }