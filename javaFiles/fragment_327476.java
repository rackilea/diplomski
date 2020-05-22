package foo;
class Test {
    public static void main(String[] args) {
        // note: the parameter is the library name, no extension, no path
        System.loadLibrary("opencv_java320");
        System.out.println("library loaded");
    }
}