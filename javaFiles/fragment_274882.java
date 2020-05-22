if(dec.equals("Y") || dec.equals("y")){
    Iterator<ArrayList<Integer>> it = al.iterator();
    // Iterator<Integer> it2 = al2.iterator();
    while(it.hasNext()){
        ArrayList<Integer> myList = it.next();
        Iterator<Integer> it2 = myList.iterator();
        while(it2.hasNext()){
            System.out.print(it2.next() + " ");
        }
        System.out.println();
    }
    break;
}