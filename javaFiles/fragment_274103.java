public class LowerCaseFirstComaparor implements Comparator<Character> {
    @Override
    public int compare (Character c1, Character c2) {
        if (Character.isLowerCase(c1)) {
            if (Character.isLowerCase(c2)) {
                return c1.compareTo(c2);
            } else {
                return -1;
            }
        } else if (Character.isLowerCase(c2)) {
            return 1;
        } else {
            return c1.compareTo(c2);
        }
}