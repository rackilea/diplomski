class Sphere extends Shape {
    int radius;
    Paint paint;
    Sphere(Paint paint){
    this.paint = paint;
    }
    public float area(){
        return (float) (4*3.14*radius*radius);
    }
    public float paint(){
        return paint.paint_sphere(this);
    }