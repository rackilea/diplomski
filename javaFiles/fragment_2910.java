@Override
public void targetFinished(BuildEvent event) {

if (event.getTarget().getName().trim().equalsIgnoreCase("RUN-MYCLASS")) {
    String buildRc = event.getTarget().getProject().getProperty("build.rc");    
    tester.setReturnCode(buildRc);
}