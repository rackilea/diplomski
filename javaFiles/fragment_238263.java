public static boolean checkDuplicate(ArrayList<String> list) {

    HashSet<String> set = new HashSet<String>();
    for (int i = 0; i < list.size(); i++) { // iterate over all elements of input list
        boolean isUnique = set.add(list.get(i)); // returns false if list.get(i) 
                                                 // is already in the Set
        if (!isUnique) { // returns false if a non unique element was found
            return isUnique;
        }
    }
    return true; // return true if all the elements in the input List are unique

}