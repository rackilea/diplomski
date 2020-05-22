public void bindAllArgsAsStrings(String[] bindArgs) {
    if (bindArgs != null) {
        for (int i = bindArgs.length; i != 0; i--) {
            bindString(i, bindArgs[i - 1]);
        }
    }
}

private void bind(int index, Object value) {
    if (index < 1 || index > mNumParameters) {
        throw new IllegalArgumentException("Cannot bind argument at index "
                + index + " because the index is out of range.  "
                + "The statement has " + mNumParameters + " parameters.");
    }
    mBindArgs[index - 1] = value;
}