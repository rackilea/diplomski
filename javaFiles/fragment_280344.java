// Class that processes the @EndLogging annotation
@Component
public class SomeClass {

    @Value("${business.value}")
    private String defaultBusinessOperationName;

    @Value("${process.value}")
    private String defaultProcessName;

    public void processAnnotation(EndLogging annotation) {
        // ...

        String businessOperationName = annotation.BusinessOperationName();
        if (businessOperationName.equals("NOME_BUSINESSOPERATIONNAME_UNDEFINED")) {
            businessOperationName = defaultBusinessOperationName;
        }

        String processName = annotation.ProcessName();
        if (processName.equals("NOME_MICROSERVZIO_UNDEFINED")) {
            processName = defaultProcessName;
        }

        // ...
    }
}