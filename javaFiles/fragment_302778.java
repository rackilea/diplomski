public static void main(String[] args)
{
    String[] animals = new String[] { "cat", "dog", "pig", "goat",
            "donkey", "horse", "cow" };

    Map<Integer, String> map = new HashMap<>();

    // load map for test
    map.put(1, "My friend has a horse");
    map.put(2, "A bear can be big"); // will not be found
    map.put(3, "A cat is a loner");
    map.put(4, "A dog is man's best friend");
    map.put(5, "The cat and the dog are peacefully sleeping");

    // count how many there are
    Map<String, Integer> numAnimals = new HashMap<>();

    for (String animal : animals) {
        numAnimals.put(animal, countAnimal(animal, map));
    }

    System.out.println(numAnimals);
}



static Integer countAnimal(String animal, Map<Integer, String> map)
{
    int cnt = 0;
    for (String val : map.values()) {
        // split the val by space
        String[] tokens = val.split("[\\s]+");
        for (String token : tokens) {
            if (token.equalsIgnoreCase(animal)) {
                ++cnt;
            }
        }
    }

    return new Integer(cnt);
}