try {
    //  foo does not exist
    var stream = new Packages.java.io.FileInputStream("foo");
} catch (e) {
    e.rhinoException.printStackTrace();
}