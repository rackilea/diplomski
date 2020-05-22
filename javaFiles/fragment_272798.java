List retainAllButRegardingDoubles(list1, list2){

  ArrayList<Object> result = new ArrayList();

  for (Object 0:list1){
     int count1=Collections.frequency(list1, o);
     int count2=Collections.frequency(list2, o);
     int iMin=Math.min(count1,count2);
        for(int i=iMin;i>0;i--){
            result.add(o);
        }
    }
  return result;
 }