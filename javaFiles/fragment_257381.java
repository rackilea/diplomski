public String formatList(List<?> list) {
    StringBuilder b = new StringBuilder();
    for(Object o : list) {
        b.append(o);
    }
    return b.toString();
}