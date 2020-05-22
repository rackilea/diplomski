int[] generateCoordinates() {
    Random random = new Random();
    return new int[] {
            random.nextInt(100),
            random.nextInt(100),
            random.nextInt(100)
    };
}