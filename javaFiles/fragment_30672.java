@PatchMapping("/shows")
fun shows(@RequestBody json: ShowJSON) : ResponseEntity<Response> {
    return try {
        ResponseEntity(ShowResponse(actionFactory.upsert(json)), HttpStatus.OK)
    } catch (e: Exception) {
        handleException(e)
    }
}

private fun handleException(e: Exception) : ResponseEntity<Response> {
    if (e is BadRequestException) {
        return ResponseEntity(BadRequestResponse(e.message, e.errors), HttpStatus.BAD_REQUEST)
    } else if (e is NoElementFoundException) {
        return ResponseEntity(NoElementFoundResponse(e.message, e.type, e.model_id), HttpStatus.NOT_FOUND)
    }

    return ResponseEntity(UnknownErrorResponse(), HttpStatus.OK)
}