public void makeTab(String args, List<String> command, Enum[] values) {
    for (Enum commd : values) {
        String lowerName = commd.name().toLowerCase()
        if (lowerName.startsWith(args)) {
            command.add(lowerName);
        }
    }
}