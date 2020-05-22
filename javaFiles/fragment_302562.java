return NodeBuilder.nodeBuilder()
        .local(true)
        .settings(settings)
        .build()
        .start()
        .client();