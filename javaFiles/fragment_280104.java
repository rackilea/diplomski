public boolean inBounds(float cx, float cy, int size)
    {
        tmpRect1.set(x, y, this.size, this.size);
        tmpRect2.set(cx, cy, size, size);

        return tmpRect1.overlaps(tmpRect2); // returns true if rectangles are overlapping, and false if not

    }