task checkJavaVersion << {
    if (!JavaVersion.current().isJava6()) {
        String message = "ERROR: Java 1.6 required but " +
                          JavaVersion.current() +
                          " found. Change your JAVA_HOME environment variable.";
        throw new IllegalStateException(message);
    }
}

compileJava.dependsOn checkJavaVersion