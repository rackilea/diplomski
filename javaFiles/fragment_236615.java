Random rnd = new Random();
for (int index = 0; index < 100; index++) {
    Collections.shuffle(Arrays.asList(die));
    String[] values = (String[])die.get(0);
    String value = values[rnd.nextInt(values.length)];
    System.out.println(value);
}