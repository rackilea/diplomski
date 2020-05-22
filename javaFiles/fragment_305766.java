private int countWords(String searchString) {
    int index = 0;
    boolean beginning = true;       // to check if it's the beginning of the line

    if (searchString.equals("")) {
        return 0;
    } else {
        while (true) {
            try {
                if (searchString.charAt(index) != ' ') {
                    beginning = false;
                    index++;
                } else {
                    if (!beginning) {
                        return 1 + countWords(searchString.substring(++index));
                    } else {
                        return countWords(searchString.substring(++index));
                    }
                }
            } catch (StringIndexOutOfBoundsException e) {
                if (!beginning) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}