public static void main(String[] args) throws InterruptedException {
    List<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i < 3; i++) { //Add some duplicates
        list.add(new Integer(4));
        list.add(new Integer(5));
        list.add(new Integer(6));
    }
    List<Integer> newList = new ArrayList<Integer>();
    for (Integer first : list) {
        boolean contains = false;//if this flag is false after iteration then item will be added

        for (Integer copy : newList)
            if (first.equals(copy)) {// You will have to specify your condition here
                contains = true;
                break;
            }
        if(!contains)
            newList.add(first);//add item if it was not present
    }
    System.out.println(list);
    System.out.println(newList);

}