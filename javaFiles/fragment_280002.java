// state variable
private boolean shouldPaint;

void draw() {
    background(0);

    fill(200);
    rect(10, 10, 30, 30);

    if (shouldPaint) {
        rect(50, 10, 30, 30);
    }
}

// called in other thread
someMethod() {
    shouldPaint = !shouldPaint;
}