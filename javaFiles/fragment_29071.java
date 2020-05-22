public static void main(String... args){
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> list3 = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    String[] strArray;

    if(sc.hasNextLine()) {
        strArray = sc.nextLine().split("\\s+");
        for(String item : strArray)
            list1.add(Integer.parseInt(item));
    }
    if(sc.hasNextLine()) {
        strArray = sc.nextLine().split("\\s+");
        for(String item : strArray)
            list2.add(Integer.parseInt(item));
    }
    if(sc.hasNextLine()) {
        strArray = sc.nextLine().split("\\s+");
        for(String item : strArray)
            list3.add(Integer.parseInt(item));
    }

    sc.close();
    System.out.println(list1);
    System.out.println(list2);
    System.out.println(list3);
}