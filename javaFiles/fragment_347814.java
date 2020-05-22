ArrayList<int[]> arrayList = new ArrayList<>();
arrayList.add(new int[]{1,500,20});
arrayList.add(new int[]{5,30,60});
arrayList.add(new int[]{2,10,20});

// Custom `Comparator` to sort the list of int [] on the basis of first element.
Collections.sort(arrayList, new Comparator<int[]>() {
  @Override
  public int compare(int[] a1, int[] a2) {
    return a2[0] - a1[0];  // the reverse order is define here.
  }
});

// Output to STDOUT
for(int a[] : arrayList) {
  for (int i: a){
    System.out.print(i + "\t");
  }
  System.out.println();
}