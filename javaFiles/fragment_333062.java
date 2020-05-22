int[] arr = new int[]{10,10,1,10,1,2,3,10,4,5,10,6,7,10,8,10,9,8,7,6,5,4,3,10,1,2,3,4,5,6,7,10,5,4,10,10};
int index_value = 10;

/** walk through the array and create the arraylist of arraylists */
ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
ArrayList<Integer> currAl = null;
for (int i=0; i < arr.length; i++) {
    if (arr[i] == index_value) {
        if (currAl != null && currAl.size() > 0)
            al.add(currAl);
        currAl = new ArrayList<Integer>();
    } else {
        if (currAl == null)
            currAl = new ArrayList<Integer>();
        currAl.add(arr[i]);
    }
}
if (arr[arr.length-1]!= index_value && currAl.size() > 0) {
    al.add(currAl);
}

/** print out the arraylist of arraylists */
for (int i=0; i < al.size(); i++) {
    currAl = al.get(i);
    for (int j=0; j < currAl.size(); j++) {
        System.out.print(currAl.get(j) + " ");
    }
    System.out.println();
}