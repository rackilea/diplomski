public TriangleArray (int number,  int maxSize) {
    list = new Triangle[number];
    Random random = new Random();
    for(int i = 0; i < number; list[i] = makeRandomTriangle(random, maxSize);
}

private function makeRandomTriangle(Random random, int maxSize) {
    int a = random.nextInt(maxSize) + 1,
        b = random.nextInt(maxSize) + 1;

    // |a - b| <= c <= (a + b) because of the triangle inequality
    int min = Math.max(a - b, b - a),
        max = Math.min(maxSize, a + b);
    int c = rand.nextInt((max - min) + 1) + min;
    new Triangle(a, b, x);
}