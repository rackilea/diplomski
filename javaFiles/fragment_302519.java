int key = 0;
Map<Integer, int[]> map = new HashMap<>();
while (key < 5) {
int[] valueArray = new int[3];
    for (int i = 0; i < 3; i++) {
        valueArray[i] = key;
    }
    System.out.println(Arrays.toString(valueArray));
    map.put(key, valueArray);
    key++;
}
for (int i = 0; i < map.size(); i++) {
    System.out.println("Key: " + i + " Value: " + Arrays.toString(map.get(i)));
}