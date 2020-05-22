package hello;

public class MySuffixBasedPortTypesProvider extends SuffixBasedPortTypesProvider {

    private String requestSuffix = DEFAULT_REQUEST_SUFFIX;

    public String getRequestSuffix() {
        return requestSuffix;
    }

    public void setRequestSuffix(String requestSuffix) {
        this.requestSuffix = requestSuffix;
    }

    @Override
    protected String getOperationName(Message message) {
        String messageName = getMessageName(message);
        String result = null;
        if (messageName != null) {
            if (messageName.endsWith(getResponseSuffix())) {
                result = messageName.substring(0, messageName.length() - getResponseSuffix().length());
            } else if (messageName.endsWith(getFaultSuffix())) {
                result = messageName.substring(0, messageName.length() - getFaultSuffix().length());
            } else if (messageName.endsWith(getRequestSuffix())) {
                result = messageName.substring(0, messageName.length() - getRequestSuffix().length());
            }
        }
        return result;
    }

    @Override
    protected boolean isInputMessage(Message message) {
        String messageName = getMessageName(message);

        return messageName != null && !messageName.endsWith(getResponseSuffix());
    }

    private String getMessageName(Message message) {
        return message.getQName().getLocalPart();
    }

}