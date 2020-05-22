// java 1.8
List<Widget> filterOnLastUsedByEmpty(Collection<Widget> widgets) {
    return widgets.stream().filter(w -> w.lastUsedBy == null || w.lastUsedBy.isEmpty()).collect(Collectors.toList());
}

// java < 1.8
List<Widget> filterOnLastUsedByEmpty(Collection<Widget> widgets) {
    List<Widget> r = new ArrayList<>();
    for (Widget widget : widgets) {
        if (widget.lastUsedBy == null || widget.lastUsedBy.isEmpty()) {
            r.add(widget);
        }
    }
    return r;
}