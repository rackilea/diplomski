class Shape {
    public double getValue() {
        return 0.0;
    }
}

class Circle {
    public double radius;
    @Override
    public double getValue() {
        return radius;
    }
}

class Rectangle {
    public int vertices;
    @Override
    public double getValue() {
        return (double)vertices;
    }
}