Map<String, List<Integer>> map = new HashMap<>();
Scanner sc = new Scanner(new File("myfile.txt"));
while(sc.hasNextLine()) {
    String name = sc.nextLine();
    int deposit = Integer.parseInt(sc.nextLine());
    List<Integer> deposits = map.get(name);
    if(deposits == null) {
        deposits = new ArrayList<>();
        map.put(name, deposits);
    }
    deposits.add(deposit);
}