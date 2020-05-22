void vowelCount() {
    char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
    int[] count = new int[vowels.length];
    int maxCount = 0;
    char maximumChar = ' ';

    for (int i = 0; i < TEXT.length(); i++) {
        char ch = TEXT.charAt(i);
        for (int j=0; j<vowels.length; j++) {
            if (ch == vowels[j]) {
                count[j]++;
                break;
            }
        }
    }

    for (int i = 0; i<vowels.length; i++) {
        if (count[i] > maxCount) {
            maxCount = count[i];
            maximumChar = vowels[i];
        }
    }

    System.out.println();
    System.out.println("The most used lowercase vowel is " + maximumChar + " for " + maxCount + " times.");
}