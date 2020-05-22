try {
    List<String> output = RootTools.sendShell(command);

    String[] commands = new String[] { command1, command2 };
    List<String> otherOutput = RootTools.sendShell(commands);
} catch (IOException e) {
    // something went wrong, deal with it here
}