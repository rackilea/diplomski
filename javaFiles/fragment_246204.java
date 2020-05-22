String tabindexes = (String) component.getAttributes().get("tabindexes");
if (tabindexes != null) {
    String[] tabindexItems = tabindexes.split("\\s*,\\s*");
    String indexKey = component.getClientId(context) + "_currentTabIndex";
    Integer index = (Integer) component.getAttributes().get(indexKey);
    if (index == null || index == tabindexItems.length) {
        index = 0; // Note this thus restarts at 0 if there are more selectitems than tabindexes. Just to be on the safe side.
    }
    String tabindex = tabindexItems[index];
    component.getAttributes().put(indexKey, ++index); // We need to save it for the next generated input element.
    writer.writeAttribute("tabindex", tabindex, "tabindex");
}