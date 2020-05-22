public void setParagraphAttributes(AttributeSet attr, boolean replace) {
    int p0 = getSelectionStart();
    int p1 = getSelectionEnd();
    StyledDocument doc = getStyledDocument();
    doc.setParagraphAttributes(p0, p1 - p0, attr, replace);
}