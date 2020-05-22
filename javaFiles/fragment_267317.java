import org.apache.commons.vfs.*;

public class IsoReader {

    public static void main(String[] args) throws FileSystemException {
        FileSystemManager fsManager = VFS.getManager();
        FileObject isoFile = fsManager.resolveFile("iso:/path/to/file.iso");
    }

}