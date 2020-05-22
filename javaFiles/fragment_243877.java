public int getSecondListValue(ArrayList<String> list1, ArrayList<Integer> list2, String compare) {

    for (int i = 0; i < list1.size() && i < list2.size(); i++) {
        if (list1.get(i).equals(compare)) 
            return list2.get(i);
    }
    return null;
}