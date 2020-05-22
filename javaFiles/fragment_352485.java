public class TestLogger extends RunListener {
private static Map<String[], String[]> requirementsMap = new LinkedHashMap<String[], String[]>();

public void testFinished(Description description) {
    if (description.getAnnotation(Trace.class) != null){
        String[] testDescription = { description.getClassName(), description.getMethodName() };
        requirementsMap.put(testDescription, description.getAnnotation(Trace.class).RQ());
    }
}

@Override
public void testRunFinished(Result result) throws Exception {

    XMLRequirementsReporter writer = new XMLRequirementsReporter();
    writer.writeXMLReport(requirementsMap);
    super.testRunFinished(result);
    }
}