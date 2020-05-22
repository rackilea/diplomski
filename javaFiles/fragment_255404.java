@ApiOperation(  value = "Find quiz by ID",
        notes = "Returns a quiz with given ID",
        responseClass = "models.Quiz" )
@ApiErrors(     value = {
        @ApiError(code = 400, reason = "Invalid ID supplied"),
        @ApiError(code = 404, reason = "Quiz not found") })
public static Result getQuizById(
        @ApiParam(value = "ID of question that needs to be fetched", required = true) @PathParam("quizId")
        String quizId) {

    ObjectNode result = Json.newObject();
    return ok(result);
}