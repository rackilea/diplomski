private void shuffle(String[] strings) {
    Random random = new Random();
    for (int i = strings.length - 1; i > 0; i--) {
        int index = random.nextInt(i + 1);
        String temp = strings[i];
        strings[i] = strings[index];
        strings[index] = temp;
    }
}