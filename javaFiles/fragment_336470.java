public static void main(String... args){

    List<Term> obj_listTerm = new ArrayList<>();
     //add all the data you given in question
    obj_listTerm .add(new Term('Z', 4)); 
    obj_listTerm .add(new Term('Q', 2));
    obj_listTerm .add(new Term('c', 3));

    // print without Sorting your Term ArrayList.
    System.out.println("This is the list unsorted: " + myTermList);
    // Sort Using Collections.sort() Method.

    Collections.sort(myTermList);

    // After applying sort() you may see your Sorted ArrayList.
    System.out.println("This is the list SORTED: " + myTermList);
}