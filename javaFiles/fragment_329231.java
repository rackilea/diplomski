public class Anagram {
public static void main(String[] args) {
    String text = "!Hello123 ";
    char[] chars = text.toCharArray();

    int left = 0;
    int right = text.length() - 1;

    while (left < right) {
        boolean isLeftLetter = Character.isLetter(chars[left]);
        boolean isRightLetter = Character.isLetter(chars[right]);
        if (isLeftLetter && isRightLetter) {
            swap(chars, left, right);
            left++;
            right--;
        } else {
            if (!isLeftLetter) {
                left++;
            }

            if (!isRightLetter) {
                right--;
            }
        }
    }

    String anagram = new String(chars);
    System.out.println(anagram);
}

private static void swap(char[] chars, int index1, int index2) {
    char c = chars[index1];
    chars[index1] = chars[index2];
    chars[index2] = c;
}