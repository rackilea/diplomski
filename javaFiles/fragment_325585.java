// In java 7
// Declare your interface
public interface ImageListener {
    public void completed(Image image);
}

// ...
// Define your `getImage` function to use the listener
public static void getImage(ImageListener completion) {
    completion.completed(image);
}

// ...
// Call the function
Utility.getImage(new ImageListener() {
    public void completed(Image image){
        imageView.image = image;
    }
});