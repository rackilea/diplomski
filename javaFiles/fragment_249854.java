import org.apache.commons.io.FileUtils

if (Files.exists(path)) {
    FileUtils.cleanDirectory( new File("/dir/path"));
} else {
    new File("/dir/path").mkdir();
}