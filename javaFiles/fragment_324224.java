public class KebabCaseProcessor extends ServletModelAttributeMethodProcessor {

    public KebabCaseProcessor(boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    private final Map<Class<?>, Map<String, String>> replaceMap = new ConcurrentHashMap<Class<?>, Map<String, String>>();

    @Override
    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest nativeWebRequest) {
        Object target = binder.getTarget();
        Class<?> targetClass = target.getClass();
        if (!replaceMap.containsKey(targetClass)) {
            Map<String, String> mapping = analyzeClass(targetClass);
            replaceMap.put(targetClass, mapping);
        }
        Map<String, String> mapping = replaceMap.get(targetClass);
        ServletRequestDataBinder kebabCaseDataBinder = new KebabCaseRequestDataBinder(target, binder.getObjectName(), mapping);
        requestMappingHandlerAdapter.getWebBindingInitializer().initBinder(kebabCaseDataBinder, nativeWebRequest);
        super.bindRequestParameters(kebabCaseDataBinder, nativeWebRequest);
    }

    private static Map<String, String> analyzeClass(Class<?> targetClass) {
        Field[] fields = targetClass.getDeclaredFields();
        Map<String, String> renameMap = new HashMap<String, String>();
        for (Field field : fields) {
            XmlElement xmlElementAnnotation = field.getAnnotation(XmlElement.class);
            JsonProperty jsonPropertyAnnotation = field.getAnnotation(JsonProperty.class);
            if (xmlElementAnnotation != null && !xmlElementAnnotation.name().isEmpty()) {
                renameMap.put(xmlElementAnnotation.name(), field.getName());
            } else if (jsonPropertyAnnotation != null && !jsonPropertyAnnotation.value().isEmpty()) {
                renameMap.put(jsonPropertyAnnotation.value(), field.getName());
            }
        }
        if (renameMap.isEmpty())
            return Collections.emptyMap();
        return renameMap;
    }
}