public static void main(String[] args) {
    Main mApp = new Main();
    HashMap<String, Integer> markList = new HashMap<>();

    System.out.println("1.Add Mark\n2.Delete Mark\n3.Show Mark");
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    sc.close();
    if (x == 1) {
        mApp.scanMark();
    }
}