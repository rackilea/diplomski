@POST
@ApiOperation(
        consumes = MediaType.APPLICATION_JSON,
        httpMethod = "POST",
        value = "Configuring Android Platform Settings",
        notes = "Configure the Android platform settings using this REST API"
)
@ApiResponses(value = {
        @ApiResponse(code = 201, message = "Android platform configuration saved successfully"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
Message configureSettings(@ApiParam(name = "configuration", value = "AndroidPlatformConfiguration")
                                  TenantConfiguration configuration) throws AndroidAgentException;