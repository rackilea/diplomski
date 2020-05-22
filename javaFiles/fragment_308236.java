public static void interLeave(ArrayList<String> list1, ArrayList<String> list2) 
{ 

    ArrayList<String> tempList = new ArrayList<String>();

    int length = Math.max(list1.size(), list2.size());

    for (int j = 0; j<length; j++)
    {
        if (j < list1.size()) {
            tempList.add(2*j, list1.get(j));
        }
        if (j < list2.size()) {
            tempList.add(2*j+1, list2.get(j));
        }
    }
    list1.clear();
    list1.addAll(tempList);
}