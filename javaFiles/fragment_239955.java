static {
    // ...
    String agent = java.security.AccessController
            .doPrivileged(new sun.security.action.GetPropertyAction(
                    "http.agent"));
    if (agent == null) {
        agent = "Java/" + version;
    } else {
        agent = agent + " Java/" + version;
    }
    userAgent = agent;

    // ...
}