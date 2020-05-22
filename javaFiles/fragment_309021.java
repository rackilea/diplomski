List<String> l1= new ArrayList<>();

l1.add("Apple");
l1.add("Orange");
l1.add("Apple");
l1.add("Milk");

HashSet<String> set = new HashSet<>(l1);

for (String item : set) {
    if (l1.stream().filter(x -> !x.equals(item)).count() == l1.size() - 1) {
        System.out.println(item);
    }
}