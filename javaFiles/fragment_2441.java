public int maxLengthOfString(List<String> listOfStrings) {
    int maxLength = Integer.MIN_VALUE;
    if (listOfStrings != null)
        for(String s : listOfStrings)
            if (maxLength < s.length())
                maxLength = s.length();
     return maxLength;
}