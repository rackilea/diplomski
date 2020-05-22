if (System.getProperty("com.sun.management.jmxremote") == null) {
    System.out.println("JMX remote is disabled");
} else [
    String portString = System.getProperty("com.sun.management.jmxremote.port");
    if (portString != null) {
        System.out.println("JMX running on port "
            + Integer.parseInt(portString));
    }
}