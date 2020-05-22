private static void changeX() {

    Random generator = new Random();

    List<Integer> listInt = new ArrayList<Integer>();

    int x2 = generator.nextInt(10000) + 1;
    listInt.add(x2);
    int y2 = generator.nextInt(10000) + 1;
    listInt.add(y2);
    int z2 = generator.nextInt(10000) + 1;
    listInt.add(z2);

    Collections.sort(listInt);

    x = listInt.get(0);
    y = listInt.get(1);
    z = listInt.get(2);

}