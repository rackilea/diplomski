val mapper = ObjectMapper()

restTemplate.exchange(
        URI.create("http://localhost:8080/foo"),
        HttpMethod.PUT,
        HttpEntity(mapper.writeValueAsString(Order("HELLO")), HttpHeaders().apply {
            setContentType(MediaType.APPLICATION_JSON);
        }),
        Order::class.java
).addCallback(object : ListenableFutureCallback<ResponseEntity<Order>> {
    override fun onSuccess(result: ResponseEntity<Order>) {
        println("Result: ${result.body}")
    }

    override fun onFailure(ex: Throwable) {
        ex.printStackTrace()
        if (ex is HttpStatusCodeException) {
            println(ex.responseBodyAsString)
        }
    }
})