List<String> list = new ArrayList<>();
Scanner sc = new Scanner(f);
while (sc.hasNextLine()) {
    String line = sc.nextLine();
    String[] teams = line.split(",");
    list.add(teams[0]);
}
System.out.println(list.get(0));    // Australia
System.out.println(list.get(1));    // Spain