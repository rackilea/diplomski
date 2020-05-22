while(!finished) {
    List<String> input = reader.getInput();
    if(input.size() == 0) {
        throw new IllegalArgumentException("Must specify command, one of 'shutdown', 'load', 'write'");
    }

    final String command = input.remove(0).toLowerCase();
    // TODO: Make sure command is one of the valid commands!