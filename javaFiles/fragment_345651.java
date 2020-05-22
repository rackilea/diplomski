public class CharacterClassComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int l1 = o1.length();
        int l2 = o2.length();
        int length = Math.min(l1, l2);

        for (int i = 0; i < length; ++i) {
            char c1 = o1.charAt(i);
            char c2 = o2.charAt(i);

            // Compare the character classes
            int res = CharacterClass.getClass(c1).compareTo(CharacterClass.getClass(c2));
            if (res != 0) {
                return res;
            }

            // If the clases are the same, compare the actual characters
            res = Character.compare(c1, c2);
            if (res != 0) {
                return res;
            }
        }

        // All the characters up to the shared length are the same
        // Compare the lengths:
        return Integer.compare(l1, l2);
    }
}