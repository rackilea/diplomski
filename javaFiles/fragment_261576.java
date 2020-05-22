@ApiMethod(
        name = "stuff.update",
        path = "stuff/{id}",
        httpMethod = ApiMethod.HttpMethod.PUT
)
public Group update(
        User apiUser,
        @Named("id") String id,
        @Nullable @Named("name") String name,
        @Nullable @Named("description") String description,
        EndpointUpdateRequestBody requestBody)
        throws OAuthRequestException, InternalServerErrorException, NotFoundException,
        BadRequestException, UnauthorizedException, ConflictException {