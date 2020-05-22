ArrayList<Integer> allId = new ArrayList<>();
outerLoop:
 for (int i = 0; i < totalList.getSmallList().size(); i++) {
    for (int position = 0; position < totalList.getBigList().size(); position++) {
         if (totalList.getSmallList().get(i).getID() == totalList.getBigList().get(position).getID()) {
         allId.add(posotion);
         continue outerLoop;
       }
     }
   }