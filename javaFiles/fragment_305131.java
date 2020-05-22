Settings settings = settingsBuilder()
            .put("http.enabled", false)
            .put("network.host", "127.0.0.1")
            .put("cluster.name", "my_cluster_name")
            .put("node.name", "my_node_name")
            .put("path.home", HOME.getAbsolutePath())
            .put("path.conf", CONFIG.getAbsolutePath())
            .put("path.logs", LOGS.getAbsolutePath())
            .build();

    // make sure ES' logging system knows where to find our custom logging.xml
    LogConfigurator.configure(settings);

    // startup a standalone node to use for tests
    return nodeBuilder()
            .settings(settings)
            .local(true)
            .loadConfigSettings(false)
            .node();