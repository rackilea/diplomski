// Update mText and mPrecomputed
private void setTextInternal(@Nullable CharSequence text) {
    mText = text; // #### THIS IS WHERE IT SETS THE TEXT TO NON NULL ("").
    mSpannable = (text instanceof Spannable) ? (Spannable) text : null;
    mPrecomputed = (text instanceof PrecomputedText) ? (PrecomputedText) text : null;
}