private static void rearrange(boolean[] word, int start, int end) {
    int sum = 0;
    int defectIndex = -1;
    for (int i = start; i < end; i++) {
        sum = sum + (word[i] ? 1 : -1);
        if (defectIndex < 0 && sum < 0) {
            defectIndex = i;
        } else if (defectIndex >= 0 && sum == 0) {
            // We now have irreducible u = rtl spanning [defectIndex, i]
            int uLength = i - defectIndex + 1;
            boolean[] flipped = new boolean[uLength - 2];
            for (int j = 0; j < flipped.length; j++)
                flipped[j] = !word[defectIndex + j + 1];

            // Shift the remaining word
            if (i + 1 < end)
                System.arraycopy(word, i + 1, word, defectIndex + 1, end - (i + 1));

            // Rewrite uw as lwrt*, t* being the flipped array
            word[defectIndex] = true;
            System.arraycopy(flipped, 0, word, end - flipped.length, flipped.length);
            word[end - uLength + 1] = false;

            // Now recurse on w, worst case we go (word.length/2)-deep
            rearrange(word, defectIndex + 1, end - uLength + 1);
            break;
        }
    }
}