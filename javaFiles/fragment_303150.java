static int numDecodings(String encodedText) {
    // initialize the cache
    int[] cache = {1, 0, 0};

    for (int position = encodedText.length() - 1; position >= 0; position--) {
        // rotate the cache
        cache[2] = cache[1];
        cache[1] = cache[0];
        cache[0] = 0;

        // headSize == 1
        if (position + 0 < encodedText.length()) {
            char c = encodedText.charAt(position + 0);

            // 1 .. 9
            if ('1' <= c && c <= '9') {
                cache[0] += cache[1];
            }
        }

        // headSize == 2
        if (position + 1 < encodedText.length()) {
            char c1 = encodedText.charAt(position + 0);
            char c2 = encodedText.charAt(position + 1);

            // 10 .. 19
            if ('1' == c1) {
                cache[0] += cache[2];
            }
            // 20 .. 26
            else if ('2' == c1 && '0' <= c2 && c2 <= '6') {
                cache[0] += cache[2];
            }
        }
    }

    return cache[0];
}