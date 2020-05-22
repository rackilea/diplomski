public class AccountBeanSerializer extends JsonSerializer<AccountBean> {
    @Override
    public void serialize(AccountBean accountBean, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeNumberField("sample_id", accountBean.getSampleId());
        List<ParameterBean> parameters = accountBean.getParameters();
        for (ParameterBean parameterBean : parameters) {
            jgen.writeStringField(parameterBean.getName(),
                    parameterBean.getValue());
        }
        jgen.writeEndObject();
    }
}