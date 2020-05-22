static final int upperLimit  = 26;
static final int maxHeadSize = ("" + upperLimit).length();

static int numDecodings(String encodedText) {
    return numDecodings(encodedText, new Integer[1 + encodedText.length()]);
}

static int numDecodings(String encodedText, Integer[] cache) {
    // check base case for the recursion
    if (encodedText.length() == 0) {
        return 1;
    }

    // check if this tail is already known in the cache
    if (cache[encodedText.length()] != null) {
        return cache[encodedText.length()];
    }

    // cache miss -- sum all tails
    int sum = 0;
    for (int headSize = 1; headSize <= maxHeadSize && headSize <= encodedText.length(); headSize++) {
        String head = encodedText.substring(0, headSize);
        String tail = encodedText.substring(headSize);
        if (Integer.parseInt(head) > upperLimit) {
            break;
        }
        sum += numDecodings(tail, cache);  // pass the cache through
    }

    // update the cache
    cache[encodedText.length()] = sum;
    return sum;
}