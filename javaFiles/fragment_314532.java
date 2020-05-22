Mono<Void> fileWritten = WebClient.create().post()
        .uri(uriBuilder -> uriBuilder.path("/file/").build())
        .exchange()
        .flatMap(response -> {
            if (MediaType.APPLICATION_JSON_UTF8.equals(response.headers().contentType().get())) {
                Mono<NoPayloadResponseDto> dto = response.bodyToMono(NoPayloadResponseDto.class);
                return createErrorFile(dto);
            }
            else {
                Flux<DataBuffer> body = response.bodyToFlux(DataBuffer.class);
                return createSpreadsheet(body);
            }
        });
// Once you get that Mono, you should give plug it into an existing
// reactive pipeline, or call block on it, depending on the situation