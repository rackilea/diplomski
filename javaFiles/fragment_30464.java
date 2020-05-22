public String center (String s, int length) {
    if (s.length() > length) {
        return s.substring(0, length);
    } else if (s.length() == length) {
        return s;
    } else {
        int leftPadding = (length - s.length()) / 2; 
        StringBuilder leftBuilder = new StringBuilder();
        for (int i = 0; i < leftPadding; i++) {
            leftBuilder.append(" ");
        }

        int rightPadding = length - s.length() - leftPadding;
        StringBuilder rightBuilder = new StringBuilder();
        for (int i = 0; i < rightPadding; i++) 
            rightBuilder.append(" ");

        return leftBuilder.toString() + s 
                + rightBuilder.toString();
    }
}