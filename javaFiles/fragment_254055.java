@Override
public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
    InputConnection inputConnection = super.onCreateInputConnection(outAttrs);
    if (inputConnection == null)
    {
        return null;
    }
    return new MyInputConnectionWrapper(inputConnection,
            true);
}