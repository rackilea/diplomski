public void set(Vector2f start, Vector2f end) {
    super.pointsDirty = true;
    if (this.start == null) {
        this.start = new Vector2f();
    }
    this.start.set(start);

    if (this.end == null) {
        this.end = new Vector2f();
    }
    this.end.set(end);

    vec = new Vector2f(end);
    vec.sub(start);

    lenSquared = vec.lengthSquared();
}