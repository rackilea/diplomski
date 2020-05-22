public void helper(char[] s, int left, int right) {
    Intrinsics.checkParameterIsNotNull(s, "s"); // add the same call here

    if (left >= right) return;
    char tmp = s[left];
    s[left] = s[right];
    s[right] = tmp;
    helper(s, left + 1, right - 1);
}