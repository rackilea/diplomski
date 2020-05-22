public static void main(String... args) {
        String s = "(This is level 1. (This is level 2. (This is level 3.) Back to level 2.) Back to level 1.)";
        searchInto(s);
    }

    public static void searchInto(String s){
        searchInto(s, s.length(), 0);
    }

    public static void searchInto(String s, int from, int to){
        int nextOpen = s.lastIndexOf("(", from-1);
        if(nextOpen >= 0){
            int nextClose = s.indexOf(")", to);

            System.out.println(s.substring(nextOpen + 1, nextClose));
            searchInto(s, nextOpen, nextClose + 1);
        } else
            return;
    }