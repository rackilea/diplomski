public class HttpHeaderExampleInterceptor extends AbstractPhaseInterceptor
{
private static final String HEADER_NAME = "header_name";
private String value;

public HttpHeaderExampleInterceptor(String value)
{
    super(Phase.MARSHAL);
    this.value = value;
}

/**
 * @see org.apache.cxf.binding.soap.interceptor.SoapPreProtocolOutInterceptor#setSoapAction(SoapMessage)
 */
@Override
public void handleMessage(Message message) throws Fault
{
    Map<String, List<String>> protocolHeaders = CastUtils.cast((Map<?, ?>) message.get(Message.PROTOCOL_HEADERS));

    if (protocolHeaders == null)
    {
        protocolHeaders = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        message.put(Message.PROTOCOL_HEADERS, protocolHeaders);
    }

    protocolHeaders.put(HEADER_NAME, Collections.singletonList(value));
}
}