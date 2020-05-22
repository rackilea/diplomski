import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.util.json.Jackson;

public class PartETagExt extends PartETag {

    public PartETagExt() {
        super(0, "a");
    }

    public PartETagExt(PartETag partETag) {
        super(partETag.getPartNumber(), partETag.getETag());
    }

    @Override
    public String toString() {
        return Jackson.toJsonString(this);
    }
}