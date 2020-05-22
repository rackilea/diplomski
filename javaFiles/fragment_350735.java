interface Shape {
    void draw(int[] data);
}

class Polygon implements Shape {
    public void draw(int[] data) {
        // Draw polygon using points data[i], data[i+1] for points
    }
}

class Circle implements Shape {
     public void draw(int[] data) {
         // Draw circle using data[0], data[1] for the center, and data[2] for radius
     }
}