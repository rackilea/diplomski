// Skip the interface declaration and use a predefined Java 8 Functional interface:
public static void getImage(Consumer<Image> completion) {
    completion.accept(image);
}

// ...
// Call the function
Utility.getImage(image -> imageView.image = image);