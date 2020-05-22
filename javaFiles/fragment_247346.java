public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        int pfx = betterPrefix(a[0],b[0]);
        if (pfx != 0)
            return pfx;
        return a.compareToIgnoreCase(b);
    }


    private int betterPrefix(char a, char b) {
        String prefixOrder = "@%&+"

        int idxa = prefixOrder.indexOf(a);
        if (idxa < 0) idxa = prefixOrder.length();
        int idxb = prefixOrder.indexOf(b);
        if (idxb < 0) idxb = prefixOrder.length();

        return idxa - idxb;
    }       
}