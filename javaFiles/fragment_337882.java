public static void main(String[] args) {
    List<Integer> list=Arrays.asList(2,3,4,5,8,10,11,12,15,16,17,18,19,25);
    List<List<Integer>>lList=new ArrayList<List<Integer>>(); //list of list of integer
    System.out.println("list:" + list);
    int i=0;
    int start=0;
        List<Integer> sList=new ArrayList<Integer>(2);
        for(  i = 1; i <list.size();i++){

           if( list.get(i - 1) + 1 != list.get(i)){
               sList.add(list.get(start));
               sList.add(list.get(i-1));
               lList.add(sList);
               sList=new ArrayList<Integer>(2);
               start=i;

            }

        }
        sList.add(list.get(start));        // for last range
        sList.add(list.get(list.size()-1));
        lList.add(sList);


    System.out.println("Range :"+lList);
}