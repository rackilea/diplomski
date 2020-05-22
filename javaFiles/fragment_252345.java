@Override public View onCreateInputView() {
    // load preferences

    return mInputView;
}


@Override public void onStartInputView(EditorInfo attribute, boolean restarting) {
    super.onStartInputView(attribute, restarting);

    setInputView(onCreateInputView());

    ...
}