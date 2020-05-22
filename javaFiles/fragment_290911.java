...
public void reverseString(char[] s) {
    this.helper(s, 0, s.length - 1);
}

public void helper(char[] s, int left, int right) {
    if (left < right) {
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        this.helper(left, right, s);
    }
}
...