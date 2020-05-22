@Consumes("application/json")
class UserDtoReader extends MessageBodyReaderSupport<UserDto> {

    @Override
    public UserDto readFrom(MultivaluedMap<String, String> httpHeaders,
            InputStream entityStream) throws IOException,
            WebApplicationException {
        return new JsonSlurper().parse(new InputStreamReader(entityStream))
    }
}