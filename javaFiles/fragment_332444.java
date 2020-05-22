if (System.getProperty("os.name").contains("Windows")) {
    // Windows
    System.setProperty("org.lwjgl.librarypath", new File("lwjglFolderLocation/native/windows").getAbsolutePath());
} else if (System.getProperty("os.name").contains("Mac")) {
    // Mac OS X
    System.setProperty("org.lwjgl.librarypath", new File("lwjglFolderLocation/native/macosx").getAbsolutePath());
} else if (System.getProperty("os.name").contains("Linux")) {
    // Linux
    System.setProperty("org.lwjgl.librarypath", new File("lwjglFolderLocation/native/linux").getAbsolutePath());
} else if (System.getProperty("os.name").contains("Sun")) {
    // SunOS (Solaris)
    System.setProperty("org.lwjgl.librarypath", new File("lwjglFolderLocation/native/solaris").getAbsolutePath());
} else {
    throw new RuntimeException("Your OS is not supported");
}