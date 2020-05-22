static final int upperLimit  = 26;
static final int maxHeadSize = ("" + upperLimit).length();

static int numDecodings(String encodedText) {
    int[] cache = new int[encodedText.length() + 1];

    // base case: the empty string at encodedText.length() is 1:
    cache[encodedText.length()] = 1;

    for (int position = encodedText.length() - 1; position >= 0; position--) {
        // sum directly into the cache
        for (int headSize = 1; headSize <= maxHeadSize && headSize + position <= encodedText.length(); headSize++) {
            String head = encodedText.substring(position, position + headSize);
            if (Integer.parseInt(head) > upperLimit) {
                break;
            }
            cache[position] += cache[position + headSize];
        }
    }

    return cache[0];
}