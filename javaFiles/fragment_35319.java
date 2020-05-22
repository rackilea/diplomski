while (mapIterator.hasNext()) 
 {
     Map.Entry mapEntry = (Map.Entry) mapIterator.next();
     Integer keyValue = (Integer) mapEntry.getKey();
     Object[] value = (Object[]) mapEntry.getValue();
     //iterate over the array and print each value
     for (int i=0; i<value.length; i++) {
         System.out.print(value[i] + " ");
     }
     System.out.println();
 }