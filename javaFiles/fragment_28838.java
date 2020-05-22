public final void setText(CharSequence text) {
        setText(text, mBufferType);
}

// So this get string value from resources and use the above setText().
public final void setText(int resid) {
    setText(getContext().getResources().getText(resid));
}