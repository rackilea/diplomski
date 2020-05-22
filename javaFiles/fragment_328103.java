public static String[] getAllLists(String[] elements, int lengthOfList)
{

    //lists of length 1 are just the original elements
    if(lengthOfList == 1) return elements; 
    else {
        //initialize our returned list with the number of elements calculated above
        String[] allLists = new String[(int)Math.pow(elements.length, lengthOfList)];

        //the recursion--get all lists of length 3, length 2, all the way up to 1
        String[] allSublists = getAllLists(elements, lengthOfList - 1);

        //append the sublists to each element
        int arrayIndex = 0;

        for(int i = 0; i < elements.length; i++){
            for(int j = 0; j < allSublists.length; j++){
                //add the newly appended combination to the list
                allLists[arrayIndex] = elements[i] + allSublists[j];
                arrayIndex++;
            }
        }
        return allLists;
    }
}

public static void main(String[] args){
    String[] database = {"a","b","c"};
    for(int i=1; i<=database.length; i++){
        String[] result = getAllLists(database, i);
        for(int j=0; j<result.length; j++){
            System.out.println(result[j]);
        }
    }
}