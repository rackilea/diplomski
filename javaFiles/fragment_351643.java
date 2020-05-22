public static LinkedList getInstance(){
    if(theList == null){
        System.out.println("New List*********************");
        theList = new LinkedList();
    }
    return theList;
}