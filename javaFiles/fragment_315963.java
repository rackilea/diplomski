private Collection<String> relatedCommand(String input) {
        // make sure the split afterwards has at least size one
        if (input.matches(" .*")) {
            return Collections.emptyList();
        }
        final String command = input.split(" ".toString())[0];
        return COMMAND_PACKAGE
                .keySet()
                .stream()
                .map(Pattern::toString)
                .filter(patternText -> patternText.startsWith(comman))
                .collect(Collectors.toList());
  }


public Command getCommand(final String input) throws InvalidInputException {
        Collection<String> commands = relatedCommand(input)
        if (commands.size() == 1) {
            Terminal.printError("test");
            throw new InvalidInputException("invalid arguments");
        } else if (commands.isEmpty()) {
            throw new InvalidInputException("unknown command");
        } else {
            ...
        }
 }