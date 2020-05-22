void putData() {
    List<String> Images = new ArrayList<>();
    for (int x = 1; x <= 6; x++) {
        Images.add(String.valueOf(x) + ".png");
    }
    models.add(new Model(Images));
}