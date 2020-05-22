public static int findSubstr (String source, String substr) {
        if(source.contains(substr)) {
            int index =  source.indexOf(substr);
            return index;
        }
        return -1;
    }