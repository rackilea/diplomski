public class NvpComparator implements Comparator<NameValuePair> {
    @Override
    public int compare(NameValuePair arg0, NameValuePair arg1) {
        String name0 = arg0.getName();
        String name1 = arg1.getName();
        return name0.compareTo(name1);
    }
}