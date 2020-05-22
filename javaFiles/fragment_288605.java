public Representation getSwagger() {
    Definition definition = getDefinition();
    // The method to add for filtering the instropected structure
    filterDefinition(definition);
    Swagger swagger = Swagger2Translator.getSwagger(definition);
    (...)
}

protected void filterDefinition(Definition definition) {
}