public abstract class KnownIssueExtension extends AbstractAnnotationDrivenExtension<KnownIssue> {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(KnownIssueExtension.class)
    public void visitFeatureAnnotation(KnownIssue knownIssue, FeatureInfo feature) {
        DefectStatus status = null
        try{
            status = getDefectStatus(knownIssue.value())
        } catch(Exception ex){
            LOGGER.warn("Unable to determine defect status for defect ID '{}', test case {}", knownIssue.value(), feature.getName())
            // If we can't get info from Defect repository, just skip it, it should not cause failures or cause us not to execute tests.
        }
        if (status != null){
            if(!status.open && !status.fixed){
                LOGGER.error("Defect with ID '{}' and title '{}' is no longer in an open status and is not fixed, for test case '{}'.  Update or remove test case.", knownIssue.value(), status.defectTitle, feature.getName())
                feature.addInterceptor(new CauseFailureInterceptor("Defect with ID '" + knownIssue.value() + "' and title '" + status.defectTitle + "' is no longer in an open status and is not fixed, for test case '" + feature.getName() + "'.  Update or remove test case."))
            }else if (status.open && !status.fixed){
                LOGGER.warn("Defect with ID '{}' and title '{}' is still open and has not been fixed.  Not executing test '{}'", knownIssue.value(), status.defectTitle, feature.getName())
                feature.setSkipped(true)
            }else if (!status.open && status.fixed){
                LOGGER.error("Defect with ID '{}' and title '{}' has been fixed and closed.  Remove KnownIssue annotation from test '{}'.", knownIssue.value(), status.defectTitle, feature.getName())
                feature.addInterceptor(new CauseFailureInterceptor("Defect with ID '" + knownIssue.value() + "' and title '" + status.defectTitle + "' has been fixed and closed.  Remove KnownIssue annotation from test '" + feature.getName() + "'."))
            }else { // status.open && status.fixed
                LOGGER.warn("Defect with ID '{}' and title '{}' has recently been fixed.  Remove KnownIssue annotation from test '{}'", knownIssue.value(), status.defectTitle, feature.getName())
            }
        }
    }

    public abstract DefectStatus getDefectStatus(String defectId)

}

public class CauseFailureInterceptor extends AbstractMethodInterceptor{
    public String failureReason
    public CauseFailureInterceptor(String failureReason = ""){
        this.failureReason = failureReason
    }

    @Override
    public void interceptFeatureExecution(IMethodInvocation invocation) throws Throwable {
        throw new Exception(failureReason)
    }
}

class DefectStatus{
    boolean open
    boolean fixed
    String defectTitle
}