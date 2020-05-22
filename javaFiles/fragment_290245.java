private static final String EMPTY = "";

public String execute(final String file) {

    final String executionId = fileHandler.getExecutionIdFromFileName(file);

    if (EMPTY.equals(executionId)) {
        return EMPTY;
    }

    final String xmlFileName = fileHandler.getXmlFileFromFileName(file);

    if (EMPTY.equals(xmlFileName)) {
        return EMPTY;
    }

    Foo foo = fooRepository.getFooByXmlFileName(xmlFileName);

    if (foo == null) {
        return EMPTY;
    }

    return foo.DoThat(file);
}