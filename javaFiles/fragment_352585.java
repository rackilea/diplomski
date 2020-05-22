import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Files.class)
public class TestVisitor {
  public class PrintingVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult postVisitDirectory(final Path dir, final IOException exc) throws IOException {
      Files.delete(dir);
      return FileVisitResult.CONTINUE;
    }
  }

  @Test
  public void testPostVisitDirectory() throws Exception {
    final Path mockedPath = Paths.get("sample path");

    /* Mocking */
    PowerMockito.mockStatic(Files.class);
    PowerMockito.doNothing().when(Files.class, PowerMockito.method(Files.class, "delete", Path.class));
    /* End Mocking */

    final PrintingVisitor visitor = new PrintingVisitor();
    Assert.assertEquals("The was a problem visiting the file", FileVisitResult.CONTINUE, visitor.postVisitDirectory(mockedPath, null));
  }
}