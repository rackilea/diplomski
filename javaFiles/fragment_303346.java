public static boolean listsContains(ArrayList<ArrayList<Integer>> lists, int v) {

    for (ArrayList<Integer> list : lists) {
        if (list.contains(v)) 
            return true;
    }

    return false; // No inner arrayList contains 'v'
}