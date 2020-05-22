public static APIError parseError(Response<?> response, Retrofit retrofit) {
    Converter<ResponseBody, APIError> converter =
            retrofit.responseConverter(APIError.class, new Annotation[0]);

    APIError error;

    try {
        error = converter.convert(response.errorBody());
    } catch (IOException e) {
        e.printStackTrace();
        return new APIError();
    }

    return error;
}