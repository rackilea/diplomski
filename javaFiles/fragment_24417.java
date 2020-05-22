List<String> cmd = Arrays.asList(
    "ssh",
    "user@domain",
    "mysql",
    "-uuser",
    "-ppassword",
    "-h10.0.0.1",
    "-Ddb",
    "-e'SELECT columns FROM table'"
);