public static List<Integer> getAllIntersection(ArrayList<ArrayList<Integer>> arrayList2D) {
    List<Integer> finalList = arrayList2D.get(0);
    for (int i=1; i<arrayList2D.size(); i++) {
        finalList=intersection(finalList,arrayList2D.get(i));
    }
    System.out.println("firstList"+finalList);
    return finalList;
}