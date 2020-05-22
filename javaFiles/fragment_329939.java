List<String> vegetables = new ArrayList<>(); // Fill the lists somehow
List<String> fruits = new ArrayList<>();

for(String vegetable : vegetables) {
    for(String fruit : fruits) {
        System.out.printf("Compare %s to %s%n", vegetable, fruit);
    }
}