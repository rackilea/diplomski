public class TwitterLengthFilter implements InputFilter {
Validator tweetValidator = new Validator();
private final int max;

public TwitterLengthFilter(int max) {
    this.max = max;
}

public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                           int dstart, int dend) {

    StringBuilder destination = new StringBuilder(dest);
    String sourceString = source.subSequence(start, end).toString();
    String fullTextString = destination.replace(dstart, dend, sourceString).toString();

    Log.v("Full text", fullTextString);

    if (fullTextString.length() == 0) {
        return "";
    } else if (tweetValidator.getTweetLength(fullTextString) <= max) {
        return null; //keep original
    } else {
        CharSequence returnSource = "";
        for (int i=0; i<sourceString.length(); i++) {
            String iterateSource = source.subSequence(0, i + 1).toString();
            StringBuilder iteratedDestination = new StringBuilder(dest);
            iteratedDestination.replace(dstart, dend, iterateSource);
            if (tweetValidator.getTweetLength(iteratedDestination.toString()) <= max) {
                returnSource = source.subSequence(0, i + 1);
            }
        }
        return returnSource;
    }
}