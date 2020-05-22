public static void main(String[] args){
    Renderer r = new Renderer();                              // Create Renderer object
    r.handleRender(1f, 2f);                                   // Prints "Replace me!"
    r.replaceHandler((f, f1)->{ System.out.println(f*f1); }); // Lambda implementation
    r.handleRender(1f, 2f);                                   // Prints "2"
}