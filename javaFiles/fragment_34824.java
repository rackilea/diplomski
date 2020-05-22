for (int i = 1; i < 201; i++) {

   for(int j=2;j<11;j++){

      if(i%j==0){

         if(dataMap.containsKey(j){

           dataMap.get(j).add(i);

         }else{

           List<Integer> list = new ArrayList<Integer>();
           list.add(i);
           dataMap.put(j,list);

        }

      }

   }
}