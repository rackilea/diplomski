@SwaggerDefinition(securityDefinition = @SecurityDefinition(
    apiKeyAuthDefinitions = {
            @ApiKeyAuthDefinition(
                    key = HttpHeaders.AUTHORIZATION,
                    name = HttpHeaders.AUTHORIZATION,
                    in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER
            )
    }
))