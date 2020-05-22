public class Renderer{
    // Declare an interface which specifies a single method that handles rendering
    public interface RenderHandler{ void render(float f, float f1); }

    // Declare a default implementation that is created with each instance of the Renderer
    protected RenderHandler handler = (f, f1) -> { System.out.println("Replace me!"); };

    // Define a system of replacement for the rendering routine
    public void replaceHandler(RenderHandler replacement){
        if(replacement!=null) handler = replacement; // Determine a viable replacement
    }

    // This shows that the same method can be called but yield different results
    // based on how the RenderHandler object in the "handler" field is implemented
    public void handleRender(float f, float f1){ handler.render(f, f1); }
}