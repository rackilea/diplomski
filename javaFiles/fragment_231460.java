int[] numbers = new int[6];
Set<Integer> randomNumbers = new HashSet<>();
Random rand = new Random();
while (randomNumbers.size() < 6) {
    randomNumbers.add(rand.nextInt(50) + 1);
}
System.out.println("Six random numbers: " + randomNumbers.toString());

// if you need them as an `int` array:
int i = 0;
for (Integer n : randomNumbers) {
    numbers[i++] = n;
}