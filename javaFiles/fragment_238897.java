String grammar = "aaSbXaaSaXaSaX";
    String[] components = grammar.split("X");
    char[][] chars = new char[components.length + 1][];
    for (int i = 0; i < components.length; i++) {
        String component = components[i];
        chars[i] = component.toCharArray();
    }
    chars[components.length] = new char[] { '\0' };