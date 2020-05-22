public final class FileSystems {
    private FileSystems() {
    }
.................
.................
public static FileSystem getDefault() {
        return DefaultFileSystemHolder.defaultFileSystem;
    }

}