@Configuration
public class KebabCaseRequestDataBinder extends ExtendedServletRequestDataBinder {

    private final Map<String, String> renameMapping;

    public KebabCaseRequestDataBinder(Object target, String objectName, Map<String, String> mapping) {
        super(target, objectName);
        this.renameMapping = mapping;
    }

    protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {
        super.addBindValues(mpvs, request);
        for (Map.Entry<String, String> entry : renameMapping.entrySet()) {
            String from = entry.getKey();
            String to = entry.getValue();
            if (mpvs.contains(from)) {
                mpvs.add(to, mpvs.getPropertyValue(from).getValue());
            }
        }
    }
}