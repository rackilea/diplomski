public void randNum() {
    Random rn = new Random();

    for (int i = 0; i < rows.length(); i++)
        rows[i] = rn.nextInt(max - min + 1) + min;
}