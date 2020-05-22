import java.io.File;
import javax.activation.MimetypesFileTypeMap;

final File file = new File(basePath + "/" + fileName);
try {
    return MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(file);
} catch (final Exception exception) {
    return "<EXCEPTION: " + exception.getMessage() + ">";
}