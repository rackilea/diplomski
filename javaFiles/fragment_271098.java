private void removeDuplicates(List<String> list) {
    int count = list.size();
    for (int i = 0; i < count; i++) {
        for (int j = i + 1; j < count; j++) {
            if (list.get(i).equals(list.get(j))) {
                list.remove(j--);
                count--;
            }
        }
    }

    query1 = list.get(0);
    query2 = list.get(1);    //This
    query3 = list.get(2);    //And this, could be out of bound, for example if the list is something like {"a","a","a","a"}, so without duplicates it becomes {"a"}

    Log.d("One", list.get(0));
    Log.d("Two", list.get(1));
    Log.d("Three", list.get(2));
}