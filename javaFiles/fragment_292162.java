Try something like this:


              HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
               for(int i=0; i< arr.length; i++){

                if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i]) + 1);
                }

                else{
                  map.put(arr[i], 1);
                }

         }
            // To show the key-value pair ie element (key) and its count (value)    
        for(Map.Entry<Integer, Integer> entry :  map.entrySet()){
                System.out.println( entry.getKey() + " => " + ": " + entry.getValue() );
         }