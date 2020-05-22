public static void main(String[] args) {
    List<Parent> myList = new ArrayList<Parent>();
    Iterator<Parent> iterator = myList.iterator();
    while (iterator.hasNext()) {
        Parent p = iterator.next();
        if (p instanceof Child) {
          //do something with the Child
        }
    }
}