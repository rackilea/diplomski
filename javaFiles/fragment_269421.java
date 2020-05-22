public static void main(String[] args) {

    List<String[]> data = new ArrayList<>();
    data.add(new String[]{"bdc", "house2", "car2"});
    data.add(new String[]{"abc", "house", "car"});

    printData(data);

    Collections.sort(data, new Comparator<String[]>() {

        @Override
        public int compare(String[] o1, String[] o2) {
            return o1[0].compareTo(o2[0]);
        }
    });

    System.out.println();
    printData(data);

}

public static void printData(List<String[]> data){
    for(String[] s: data){
        System.out.println(Arrays.toString(s));
    }
}