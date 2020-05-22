// state variable
private PVector[] vectors = new PVector[5];
private int index = 0;

void draw() {
    background(0);
    fill(200);

    for (PVector v : vectors) {
        if (v != null) {
            rect(v.x, v.y, 10, 10);
        }
    }

}

// called by other thread
void someMethod() {
    if (index >= vectors.length) {
        index = 0;
    }

    // vector for current index value
    PVector v = vectors[index];

    if (v == null) {
        vectors[index] = new PVector(index * 20, index * 20);
    } else {
        vectors[index].add(new PVector(30, 0));
    }

    index++;
}