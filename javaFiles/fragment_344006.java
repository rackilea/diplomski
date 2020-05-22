public interface TextUtils {
    CharSequence concat(CharSequence...seqs);
}

public class TextUtilsAndroid implements TextUtils {
    public CharSequence concat(CharSequence...seqs) {
        return android.text.TextUtils.concat(seqs);
    }
}