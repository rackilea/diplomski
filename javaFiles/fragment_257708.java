public void setText(CharSequence text, BufferType type) {
    setText(text, type, true, 0);

    if (mCharWrapper != null) {
        mCharWrapper.mChars = null;
    }
}