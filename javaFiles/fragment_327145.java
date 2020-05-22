import de.schlichtherle.truezip.fs.archive.zip.ZipDriver;
import de.schlichtherle.truezip.socket.IOPoolProvider;

import java.util.zip.Deflater;

public class OverrideZipDriver extends ZipDriver {

  public OverrideZipDriver(final IOPoolProvider ioPoolProvider) {
    super(ioPoolProvider);
  }

  @Override
  public int getLevel() {
    return Deflater.DEFAULT_COMPRESSION;
  }
}