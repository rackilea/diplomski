HttpClients.createDefault().use {client ->
    val post = HttpPost("yourUri").apply {
        entity = ByteArrayEntity(File("yourFile").readBytes())
        // addHeader or setHeaders ... 
        addHeader("headerName", "value")
        // ... all your headers...
    }

    client.execute(post)
}