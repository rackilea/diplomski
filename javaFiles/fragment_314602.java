public enum CLIError implements IUIErrorEnum<CLIError>, IErrorEnum<CLIError> {
    ELEMENT_1,
    ELEMENT_2,
    LAST_ELEMENT;

    @Override
    public ReaderType getType() {
        return ReaderType.CLI;
    }
}