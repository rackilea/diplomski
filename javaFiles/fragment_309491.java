public class TriangleHandler extends AbstractHandler{
    public tick(AbstractShape shape){
        // Since we KNOW it's a triangle, we can cast it
        Triangle triangle = (Triangle)shape;
        triangle.doTrinagleStuff();
    }
}