ContentBean oContentBean = buildResult(Username, Path);

ObjectWriter ow = new ObjectMapper()
            .configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false)
            .writer()
            .withDefaultPrettyPrinter();

String result = "";
try {
    result = ow.writeValueAsString(oContentBean);
} catch(IOException ioe) {
    //do something
}
return result;