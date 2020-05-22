@Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        response.getHeaders().set("content-type", "text/plain;charset=UTF-8");

        //some codes..

        String result = "hello";

        try (OutputStream stream = response.getBody()) {
            stream.write(result.getBytes("utf-8"));
            stream.flush();
        } catch (IOException e) {
            // log ex
        }
        return null;
    }