public static <T> List<T> mapPayloadListToPOJOList(List<String> payloadList, Class<T> pojo) {
        return payloadList.stream()
                          .map(string -> convert(string, pojo))
                          .collect(Collectors.toList());
    }

    public static <T> T convert(String string, Class<T> pojo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(string, pojo);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }