ContentBean oContentBean = buildResult(Username, Path);
List<ContentBean> lContentBeans = new ArrayList<ContentBean>();
lContentBeans.add(oContentBean);

ObjectWriter ow = new ObjectMapper()
            .configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false)
            .writer()
            .withDefaultPrettyPrinter();

String result = "";
try {
    result = ow.writeValueAsString(lContentBeans);
} catch(IOException ioe) {
    //do something
}
return result;