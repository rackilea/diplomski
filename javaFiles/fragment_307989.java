public void sort(Drug drug, Vector<Supplier> suppliers) {
    Collections.sort(suppliers, Comparator.comparing(s -> Supplier.getKeyExtractor(s, drug)));
}

public static Integer getKeyExtractor(Supplier supplier, Drug drug) {
    return Optional.ofNullable(Optional.ofNullable(supplier.getDrugs())
                               .orElseThrow(() -> new IllegalArgumentException("drugs is null")).get(drug))
                   .orElseThrow(() -> new IllegalArgumentException("the drug couldn't be found"));
}