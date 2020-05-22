public class VectorAdapter extends XmlAdapter<String, int[]> {

    @Override
    public int[] unmarshal(final String v) throws Exception {
        final String[] strs = v.substring(1, v.length() - 1).split(",");
        final int[] vector = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            vector[i] = Integer.parseInt(strs[i].trim());
        }
        return vector;
    }

    @Override
    public String marshal(final int[] v) throws Exception {
        return null;
    }
}