Runtime.Version requiredVersion = Runtime.Version.parse("11");

if (Runtime.version().compareTo(requiredVersion) < 0) {
    System.err.println("This program requires Java 11 or later.");
    System.exit(1);
}