//------------------------------------------
// Java2Win.class
//------------------------------------------
public interface Java2Win extends Library {
    Java2Win java2Win = (Java2Win)Native.loadLibrary("Java2Win64",Java2Win.class);
    void cls();
}
//------------------------------------------

//------------------------------------------
// Java2Win.c (Java2Win.dll & Java2Win64.dll)
//------------------------------------------
JNIEXPORT void cls() {
   system("cls");
}
//------------------------------------------

//------------------------------------------
// Test
//------------------------------------------
public static void main(final String args[]) throws Exception {
    final File file = new File("rootToDLL", "Java2Win64.dll");
    LibraryLoader.loadLibrary(file);
    System.out.println("-----some output");
    System.out.println("-----some output");
    System.out.println("-----some output");
    Thread.sleep(2000);
    Java2Win.java2Win.cls();
    System.out.println("-----cleared");
}
//------------------------------------------