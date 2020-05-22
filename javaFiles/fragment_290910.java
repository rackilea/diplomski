...
public final void reverseString(@NotNull char[] s) {
    Intrinsics.checkParameterIsNotNull(s, "s");
    this.helper(0, ArraysKt.getLastIndex(s), s);
}

public final void helper(int i, int j, @NotNull char[] s) {
    Intrinsics.checkParameterIsNotNull(s, "s");
    if (i < j) {
        char t = s[j];
        s[j] = s[i];
        s[i] = t;
        this.helper(i + 1, j - 1, s);
    }
}
...