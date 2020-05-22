SynchronizedRGB color = new SynchronizedRGB(0, 0, 0, "Pitch Black");
...
synchronized(color) {
    int myColorInt = color.getRGB();      //Statement 1
    String myColorName = color.getName(); //Statement 2
}