Scanner sc = new Scanner(System.in);

List<Double> arr = new ArrayList<>(); // Use generics - never use raw types!
for (int i = 0; i < 20; ++i) {
    Double b = sc.nextDouble();
    arr.add(b);
    sc.nextLine(); // <-- add this line in order to be able to feed numbers manually
}
Double res = arr.stream().reduce(Double::sum).get();
System.out.println(res);