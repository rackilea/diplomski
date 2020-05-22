// method to do the counting of a particular animal in a map
static Integer countAnimal(String animal, Map<Integer, String> map)
{
    int cnt = 0;
    for (String val : map.values()) {
        if (val.equals(animal)) {
            ++cnt;
        }
    }

    return new Integer(cnt);
}

public static void main(String[] args)
{
    String[] animals = new String[] { "cat", "dog", "pig", "goat", "donkey", "horse", "cow" };

    Map<Integer, String> map = new HashMap<>();

    // load map for test
    Random rnd = new Random();
    for (int i = 0; i < 100; ++i) {
        String animal = animals[rnd.nextInt(animals.length)];
        map.put(new Integer(i), animal);
    }

    // count how many there are
    Map<String, Integer> numAnimals = new HashMap<>();

    for (String animal : animals) {
        numAnimals.put(animal, countAnimal(animal, map));
    }

    System.out.println(numAnimals);

    // show the cool Collections.frequency approach
    Integer count = Collections.frequency(map.values(), "dog");
    System.out.println("dog: " + count);
}