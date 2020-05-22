private fun renderErrorResponse(request: ServerRequest): Mono<ServerResponse> {

        val errorPropertiesMap = getErrorAttributes(request, false)

        request.exchange().response.headers.remove(c_ApplicationStatus)
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .headers { x -> x.set(c_ApplicationStatus, value) }
                .build()
}