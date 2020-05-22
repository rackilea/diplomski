List<String> states = Arrays.asList(
        "Utah", "Nevada", "California", "Oregon", "Utah",
        "California", "Nevada", "Nevada", "Oregon", "California"
    );

List<Integer> values = Arrays.asList(5, 6, 12, 8, 9, 10, 4, 4, 17, 6);


Map<String, List<Integer>> resultMap =HashMap<String, Arraylist<>>();

for(int i = 0; i < states.size(); i++) 
    {
           if( resultMap.get(states.get(i))!=null){
              resultMap.get(states.get(i)).add(values.get(i));
           }else{
            List<Integer> valuelist = new ArrayList<>();
             valuelist.add(values.get(i));
             resultMap.put(states.get(i),valuelist);
          }
    }