List<? extends Collection<String>> attributes = new ArrayList<HashSet<String>>(nrAttributes);

...

List<List<String>> attribs2 = new ArrayList<>();

attributes.forEach((in) -> {
    List<String> out = new ArrayList<>();
    out.addAll(in);
    attribs2.add(out);
});