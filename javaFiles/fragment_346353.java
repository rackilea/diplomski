protected int countSyllables(String word) {
    if(word.isEmpty()) return 0; //don't bother if String is empty

    word = word.toLowerCase();
    int      totalSyllables    = 0;
    boolean  previousIsVowel  = false;
    int      length = word.length();

    //check each word for vowels (don't count more than one vowel in a row)
    for(int i=0; i<length; i++) {
        //create temp variable for vowel
        boolean isVowel = isVowel(word.charAt(i));

        //use ternary operator as it is much simple (condition ? true : false)
        //only increments syllable if current char is vowel and previous is not
        totalSyllables += isVowel && !previousIsVowel ? 1 : 0;

        if(i == length - 1) { //if last index to allow for 'helloe' to equal 2 instead of 1
            if (word.charAt(length - 1) == 'e' && !previousIsVowel)
                totalSyllables--; //who cares if this is -1
        }

        //set previousVowel from temp 
        previousIsVowel = isVowel;
    }

    //always return 1 syllable
    return totalSyllables > 0 ? totalSyllables : 1;
}