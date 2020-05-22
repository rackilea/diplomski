public static void main(String[] args) {
        String delims = "\",\"";
        String splitString = "one\",\"two,\",\"three\",\"four\",\",five";

        String[] tokens = splitString.split(delims);
        int tokenCount = tokens.length;
        for (int j = 0; j < tokenCount; j++) {
            System.out.println("Split Output: "+ tokens[j]);
        }
    }