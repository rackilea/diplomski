public static void main(String[] args) {
    List<String> inputs = new ArrayList<>();
    inputs.add("Apple: 0 1");
    inputs.add("Apple: 4 5");
    inputs.add("Pear: 0 10");
    inputs.add("Pear: 11 13");
    inputs.add("Apple: 5 10");
    inputs.add("Apple: 2 4");

    Map<String, List<Fruit>> fruits = new HashMap<>();
    for (String input : inputs) {
        String[] inputPieces = input.split(" ");
        String name = inputPieces[0].replace(":", "");
        int first = Integer.parseInt(inputPieces[1]);
        int second = Integer.parseInt(inputPieces[2]);

        if (!fruits.containsKey(name)) {
            fruits.put(name, new ArrayList<Fruit>());
        }
        fruits.get(name).add(new Fruit(name, first, second));
    }

    for (String key : fruits.keySet()) {
        System.out.println(key + ": " + findDuplicates(fruits.get(key)));
    }
}

private static List<Fruit> findDuplicates(List<Fruit> fruits) {
    List<Fruit> results = new ArrayList<>();

    for (int i = 0; i < fruits.size(); i++) {
        for (int j = 0; j < fruits.size(); j++) {
            if (j == i) {
                continue;
            }

            if ((fruits.get(i).first == fruits.get(j).second) ||
                (fruits.get(j).first == fruits.get(i).second)) {
                if (!results.contains(fruits.get(i))){
                    results.add(fruits.get(i));
                }
            }
        }
    }

    return results;
}

public static class Fruit {
    private String name;
    private int first;
    private int second;

    public Fruit(String name, int first, int second) {
        this.name = name;
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("%s: %d %d", name, first, second);
    }
}