operations.stream()
.map(so -> new SimpleImmutableEntry(so, Transformer.getOperationIndex(so)))
.filter(t -> Objects.nonNull(so.getValue().getServiceOperationNumber()))
.map(t -> {
    Invoice invoice = new Invoice();
    // here's some logic using occasion and invoice

    return invoice;
})