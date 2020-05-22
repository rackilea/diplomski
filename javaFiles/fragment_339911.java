import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AtomicMove {
    private static final String ENOTEMPTY = "Directory not empty";

    public static void move(final File source, final File target) throws FileAlreadyExistsException, IOException {
        try {
            Files.move(source.toPath(), target.toPath(), StandardCopyOption.ATOMIC_MOVE);

        } catch (AccessDeniedException e) {
            // directory move collision on Windows
            throw new FileAlreadyExistsException(source.toString(), target.toString(), e.getMessage());

        } catch (FileSystemException e) {
            if (ENOTEMPTY.equals(e.getReason())) {
                // directory move collision on Unix
                throw new FileAlreadyExistsException(source.toString(), target.toString(), e.getMessage());
            } else {
                // other problem
                throw e;
            }
        }
    }
}