class Sphere extends Shape {
    int radius;
    public float area(){
        return (float) (4*3.14*radius*radius);
    }
    public float paint(){
        return new PaintThings().paint_sphere(this);
    }