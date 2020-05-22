List<List<Integer>> list3 = new ArrayList<>();

List<Integer> tmp = new ArrayList<>();
for (int i = 0; i < list1.size(); i++){
    for (int j = 0; j < list1.get(i).size(); j++){
        tmp.add(list1.get(i).get(j) + list2.get(i).get(j));
    }
    list3.add(new ArrayList<>(tmp));
    tmp.clear();
}