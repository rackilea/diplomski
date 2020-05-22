public Shape {
    private final int x;
    private final int y;
    private final double radius;

    private Shape(Builder builder) {
        x = builder.x;
        y = builder.y;
        radius = builder.radius;
    }

    public static class Builder {
        private final int x;
        private final int y;
        private double radius;

        public Builder(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Builder radius(double radius) {
            this.radius = radius;
            return this;
        }

        public Shape build() {
            return new Shape(this);
        }    
    }
}

//in client code 

    Shape rectangle = new Shape.Builder(x,y).build();
    Shape circle = new Shape.Builder(x,y).radius(radiusValue).build();