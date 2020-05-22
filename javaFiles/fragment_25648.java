static void containsName1(List<DataType> dtArrayLst, Scanner sc) {
    System.out.print("Search Nme1 : ");

    String name = sc.nextLine();
    if (dtArrayLst.contains(new DataType(name))) {
        System.out.println("Find");
    }

    System.out.println();
}

static void containsName2(List<DataType> dtArrayLst, Scanner sc) {
    System.out.print("Search Nme2 : ");

    String name = sc.nextLine();

    System.out.print("Search age: ");
    String age = sc.nextLine();

    if (dtArrayLst.contains(new DataType(name, Integer.parseInt(age)))) {
        System.out.println("Find");
    }
    System.out.println();
}

public static void main(String[] args) {
    String name = "tommybee";
    String age = "100";

    List<DataType> dtArrayLst = new ArrayList<DataType>();

    dtArrayLst.add(new DataType(name, Integer.parseInt(age)));

    Scanner sc = new Scanner(System.in);

    containsName1(dtArrayLst, sc);
    containsName2(dtArrayLst, sc);

    sc.close();
}