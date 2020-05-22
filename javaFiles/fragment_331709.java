public String getTitleText(final Element title) {
    final StringBuilder sb = new StringBuilder();
    for (final Text txt : title.getDescendants(Filters.text())) {
        final Element parent = txt.getParentElement();
        if (parent == title || 
                parent.getAttributeValue("active", "not").equals("true")) {
            sb.append(txt.getValue());
        }
    }
    return sb.toString();
}