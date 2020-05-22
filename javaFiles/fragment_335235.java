public static void main(String... args) {
        searchInto("(This is level 1. (This is level 2. (This is level 3.) Back to level 2.) Back to level 1.)");
        searchInto("(L1) (L2) (L3)");
        searchInto("(L1) (L2 (L2a)) (L3)");
    }

    public static void searchInto(String s){
        searchInto(s, s, s.length(), 0);
    }

    public static void searchInto(String s, String original, int from, int to){
        int nextOpen = s.lastIndexOf("(", from);
        if(nextOpen >= 0){
            int nextClose = s.indexOf(")", nextOpen);
            String tmp = original.substring(nextOpen + 1, nextClose);
            System.out.println(tmp); //Print the result, use a List to store or treat it directly.
            s = s.substring(0, nextOpen) + "#" + s.substring(nextOpen + 1, nextClose) + "#" + s.substring(nextClose + 1);
            searchInto(s, original, nextOpen - 1, nextClose + 1);
        } else
            return;
    }