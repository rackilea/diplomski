public void first(){
    ArrayList<Integer[]> arrayList = new ArrayList<Integer[]>();
    arrayList.add(new Integer[]{2,3,4});
    arrayList.add(new Integer[]{5,6,7});
    arrayList.add(new Integer[]{8,9,10});
    //some code
    for(int i = 0; i < arrayList.size(); i++) {
      Integer[] elementArray = arrayList.get(i);
      Integer integer = methodTakesOnlyArrays(elementArray);
      // more code...

    }
}