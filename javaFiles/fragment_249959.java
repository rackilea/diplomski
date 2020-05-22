@RestControllerAdvice
class ExceptionHandler {

    companion object {
        private val logger = getLogger()
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest(e: Exception, request: HttpServletRequest): Exception {
        val body = (request as ContentCachingRequestWrapper).contentAsByteArray.toString(Charsets.UTF_8)
        logger.error("Received a bad request with body: $body", e)
        return e
    }
}