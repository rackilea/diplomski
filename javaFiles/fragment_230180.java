public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(5);
    arrayList.add(1);
    arrayList.add(5);
    arrayList.add(1);
    arrayList.add(5);
    arrayList.add(2);
    arrayList.add(3);

    ArrayList<Integer> unique = new ArrayList<>();

    for (Integer number : arrayList) {
        if (Collections.frequency(arrayList, number) == 1) {
            unique.add(number);
        }
    }

    System.out.println(unique);
}