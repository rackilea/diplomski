HashSet<List<Object>> set = new HashSet<>();
for (Iterator<UnknownSrcClass> iterator = list.iterator(); iterator.hasNext();) {
    UnknownSrcClass element = iterator.next();
    List<Object> lst = (element == null ? null : Arrays.asList(element.getProperty1(), element.getProperty2(), ...));
    if (!set.add(lst)) {
        // handle duplicate, e.g.
        iterator.remove();
    }
}