private String runProcessor(String input, String name, Map<String, String> params) {
    Validate.notEmpty(name, "The processor name cannot be empty");
    Processor processor = processorRepository.getProcessorCalled(name);
    Options options = new Options();
    addOptions(options, params);
    return processor.run(input, options);
}

private void addOptions(Options options, Map<String, String> params) {
    params.forEach((k, v) -> {
        if (!k.equals("text")) {
            if (v != null && !v.isEmpty()) {
                options.put(k, v);
            }
        }
    });
}