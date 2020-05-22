public class NoFileBody extends InputStreamBody {

  private final long length;

  public NoFileBody(final InputStream in, final String mimeType, final String filename, final long length) {
    super(in, mimeType, filename);
    this.length = length;
  }

  @Override
  public long getContentLength() {
    return length;
  }

}