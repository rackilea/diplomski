List<Collection<String>> attributes = new ArrayList<>(nrAttributes);        

...

attributes.replaceAll((in) -> {
    List<String> out = new ArrayList<>();
    out.addAll(in);
    return out;
});