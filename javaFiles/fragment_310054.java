...
 public void List<ObjectA> match(List<ObjectA> objectsA){

       List<ObjectA> matched = new ArrayList<>();

       for (List<ObjectA> current : objectsA){

         if (fieldOne != null && !fieldOne.equals(current.fieldOne)){
                continue;                    
         }
         ...
         matched.add(current);
       }
 }