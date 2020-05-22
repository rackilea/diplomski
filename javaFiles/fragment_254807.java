Scanner sc = new Scanner(System.in);        
List<Integer> list;

while(sc.hasNext()) { // until EOF
    list = new ArrayList<>();
    while(sc.hasNextInt()) {
        int n = sc.nextInt();
        if(n == -999999)
            break;
        list.add(n);
    }
    System.out.println(list);
    // Your list of numbers are ready. Do whatever you need.
}