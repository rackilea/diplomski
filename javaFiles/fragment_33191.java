import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DirectoryTreeIterator implements Iterator<Path> {

  private final Deque<Iterator<Path>> deque = new ArrayDeque<>();

  public DirectoryTreeIterator(Iterator<Path> it) {
    deque.push(it);
  }

  @Override
  public boolean hasNext() {
    if (deque.isEmpty()) {
      return false;
    } else {
      Iterator<Path> it = deque.peek();
      if (!it.hasNext()) {
        deque.pop();
        return hasNext();
      } else {
        return true;
      }
    }
  }

  @Override
  public Path next() {
    if (hasNext()) {
      Iterator<Path> it = deque.peek();
      Path p = it.next();
      try {
        // here is the magic recursive on only filtered paths
        if (Files.isDirectory(p) && Files.isReadable(p) && !Files.isHidden(p)) {
          deque.push(Files.newDirectoryStream(p).iterator());
        }
      } catch (IOException ex) {
        throw new UncheckedIOException(ex);
      }
      return p;
    } else {
      return null;
    }
  }

}