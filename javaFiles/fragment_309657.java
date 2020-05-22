@ApiOperation( position = 100,
               value = "Retrieve SecurityToken authentication using BODY(String password)",
               notes = "Retrieve SecurityToken authentication using ReturnsId id and password",
               response = ResponseObjectClass.class)
 @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
                         @ApiResponse(code = 422, message = "business exception"),
                         @ApiResponse(code = 500, message = "Server error") })
    public ResponseObjectClass someFunctionality(@ApiParam(value = "request", defaultValue = "an string as example showing your response") @RequestBody YourRequestBodyClass request, HttpServletResponse response)
                    throws Exception {
    return new ResponseObjectClass();
}