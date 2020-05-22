public Mono<PaymentResponse> execute(PaymentTransaction transaction, WebClient client) {
        long conn = 1L;
        int sec = 1232;

        Mono<PaymentTransaction> transactionMono = Mono.just(transaction);
        return client.post()
                .uri(uriBuilder -> uriBuilder.scheme("https").host("www.test.com")
                        .path("notification")
                        .queryParam("con", conn)
                        .queryParam("sec", sec)
                        .build())
                .accept(MediaType.APPLICATION_XML)
                .contentType(MediaType.APPLICATION_XML)
                .body(transactionMono, PaymentTransaction.class)
                .retrieve()
                .bodyToMono(PaymentResponse.class);
    }