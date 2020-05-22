BinaryOperator<Label> logDuplicate = (label1, label2) -> {
    // Log label2 as duplicate
    compileResult.add(new CompileResult(Severity.FATAL, MessageFormat.format("Duplicate label found! \n Type: '{0}' \n Language: '{1}'", label2.getType(), label2.getLanguage())));
    return label1;
};

Set<Label> infos = infoRepo.getList()
                           .stream()
                           .filter(Label.class::isInstance)
                           .map(Label.class::cast)
                           .collect(toMap(identity(), identity(), logDuplicate, HashMap::new))
                           .keySet();