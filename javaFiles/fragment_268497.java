public interface LogicalTableValidator extends Function<LogicalTable, ValidationResult> {

    static LogicalTableValidator addAll(LogicalTableValidator... validators) {

        logicalTable -> {
            ValidationResult result = new ValidationResult(logicalTable.getUid());
            Arrays.stream(validators).map(v -> v.apply(logicalTable))
                    .peek(currentResult -> result.addValidationMessages(currentResult.getValidationMessages()))
                    .filter(currentResult -> currentResult.getValidationMessages().stream()
                            .filter(message -> StringUtils.equalsIgnoreCase(message.getSeverity(), "1"))
                            .count() > 0)
                    .findFirst()
                    .orElse(null);
            return result;
        }
    }

}