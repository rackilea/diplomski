public void exposeLibrary(String library, File tempDir) throws IOException {
    InputStream source = getClass().getResourceAsStream(library);
    File tempFile = new File(tempDir, library);
    FileOutputStream dest = new FileOutputStream(tempFile);
    try {
        IOUtil.copy(source, dest)
    }
    finally {
        dest.close();
        source.close();
    }    
    WinLibc.INSTANCE._putenv("PATH=" + 
        System.getenv().get("PATH") + File.pathSeparator + tempDir.getAbsolutePath());

    // After this point System.loadLibrary(library) will load the DLL.
}


public interface WinLibC extends Library {
  static WinLibC INSTANCE = Native.loadLibrary("msvcrt", WinLibC.class);

  public int _putenv(String name);
}