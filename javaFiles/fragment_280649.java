String[] split_arguments(String arguments) {
    if(arguments == null) {
        return null;
    }
    String trimmedArguments = arguments.trim();
    if(trimmedArguments.length() == 0) {
        return null;
    }

    return trimmedArguments.split("\\s+");
}