@Component
public class NtlmProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        HttpEntity httpEntity = exchange.getIn().getBody(HttpEntity.class);

        byte[] bytes = EntityUtils.toByteArray(httpEntity);

        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bytes, ContentType.get(httpEntity));

        exchange.getOut().setBody(byteArrayEntity);
    }
}