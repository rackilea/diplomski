public class FileLmWrapper implements Comparable<FileLmWrapper> {
  public final File f;
  public final long lastModified;
  public FileLmWrapper(File f) { 
    this.f = f; 
    lastModified = f.lastModified();
  }
  public int compareTo(FileLmWrapper other) {
    return Long.compare(this.lastModified, other.lastModified);
  }
}