public class DesktopFileIO implements FileIO {

  private final File externalStoragePath;
  private final File assetPath;


  // Constructor
  public DesktopFileIO(String externalStoragePath, String assetPath) {
    this(new File(externalStoragePath), new File(assetPath));
  }

  // Constructor
  public DesktopFileIO(File externalStoragePath, File assetPath) {
    super();
    this.externalStoragePath = externalStoragePath;
    this.assetPath = assetPath;
  }

  @override
  public InputStream readAsset(String fileName) throws IOException {
    return new FileInputStream( new File(assetPath, fileName) );
  }

  @override
  public InputStream readFile(String fileName) throws IOException {
    return new FileInputStream( new File(externalStoragePath, fileName) );
  }

  @override
  public OutputStream writeFile(String fileName) throws IOException {
    return new FileOutputStream( new File( externalStoragePath, fileName ) );
  }


}