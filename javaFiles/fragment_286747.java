TreeMap<Date, Document> map = ...;
final String formValue = "notice";
Collection<Document> result = Collections2.filter(map.values(), new Predicate<Document>() {
    public boolean apply(Document input) {
        return formValue .equals(input.getForm());
    }
}