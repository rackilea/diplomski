List<Integer>[] list = new List<Integer>[] {
    arrayList.subList(0, 3)
,   arrayList.subList(3, 6)
,   arrayList.subList(6, 9)
};
ArrayList<Integer> newArray = new ArrayList<Integer>();
for (int i = 0; i < 3; i++) {
    newArray.addAll(list.get(i));
}