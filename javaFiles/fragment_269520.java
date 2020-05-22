private static final int MAXIMUM_DUPLICATES = 2;
private static final int MAXIMUM_SERIES = 2;
private static final int SERIES_DIRECTION_ASCENDING = 0x42;
private static final int SERIES_DIRECTION_DESCENDING = ~SERIES_DIRECTION_ASCENDING;
public static boolean isPasswordValid(String pwd) {
    char lastChar = '\0';
    int duplicateCount = 1;
    int seriesCount = 1;
    int seriesDirection = 0; 

    char[] chars = pwd.toCharArray();
    for(char c : chars) {
        //skip the first character
        if(lastChar > 0) {
            if(lastChar == c)
                duplicateCount++;
            else
                duplicateCount = 1;

            if(lastChar == c+1) {
                //was the previous char of the same series? if not then reset the seriesCount
                if(seriesDirection != SERIES_DIRECTION_ASCENDING) {
                    seriesCount = 1;
                    seriesDirection = SERIES_DIRECTION_ASCENDING;
                }

                seriesCount++;
            } else if(lastChar == c-1) {
                if(seriesDirection != SERIES_DIRECTION_DESCENDING) {
                    seriesCount = 1;
                    seriesDirection = SERIES_DIRECTION_DESCENDING;
                }

                seriesCount++;
            } else {
                seriesCount = 1;
            }

            //are there more duplicates then are allowed?
            if(duplicateCount > MAXIMUM_DUPLICATES)
                return false;

            //is there a longer series then allowed?
            if(seriesCount > MAXIMUM_SERIES)
                return false;
        }

        //save the last character
        lastChar = c;
    }

    return true;
}