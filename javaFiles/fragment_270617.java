import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;

try {
    final ContentInfoUtil util = new ContentInfoUtil();
    final ContentInfo info = util.findMatch(basePath + "/" + fileName);

    return info.getMimeType();
} catch (final Exception exception) {
    return "<EXCEPTION: " + exception.getMessage() + ">";
}