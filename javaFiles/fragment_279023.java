public class VersionStringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String[] s1parts = s1.split("\\.");
        String[] s2parts = s2.split("\\.");
        int commonLength = Math.min(s1parts.length, s2parts.length);

        // Loop and compare corresponding parts
        for (int i = 0; i < commonLength; ++i) {
            int partCompare = 
                Integer.compare(Integer.parseInt(s1parts[i]),
                                Integer.parseInt(s2parts[i]));
            if (partCompare != 0) {
                return partCompare;
            }
        }

        // Out of parts - the shorter array should come first
        return Integer.compare(s1parts.length, s2parts.length);
    }
}