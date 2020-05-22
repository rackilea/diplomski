// Class that defines the template method
// Generic parameter allows to define the specific type of image
// that will be handled by this image renderer
public abstract class ImageRenderer<T extends Image> {

    // This is the template method
    // It's final to avoid that subclasses override it
    public final void display(String title, T image) {
        // Display title
        this.displayTitle(title);
        // Let subclasses display specific type of image
        this.displayImage(image);
    }

    // Display title for every image type
    // This method is private since it's only called
    // from within the template method
    // (make it protected if you want to let subclasses 
    // override it, i.e. for custom title displaying)
    private void displayTitle(String title) {
        // Display title, no matter the image type
    }

    // Placeholder method, no implementation
    // Actual implementation is delegated to subclasses
    protected abstract void displayImage(T image);
}