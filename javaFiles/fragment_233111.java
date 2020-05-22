public class MavenInvoker {

    public static void main(String[] args) throws IOException, NoHeadException, GitAPIException 
{
    MavenInvoker toto = new MavenInvoker();

    toto.updateVersionMavenInvoker("2.2.8-SNAPSHOT", "TECHNICAL\\WEB" );
}

private InvocationRequest request = new DefaultInvocationRequest();
private DefaultInvoker invoker = new DefaultInvoker();

public InvocationResult updateVersionMavenInvoker(String newVersion, String folderPath)
{
    InvocationResult result = null;
    request.setPomFile( new File(folderPath+"\\pom.xml" ) );

    String version =  "-DnewVersion="+newVersion;
    request.setGoals( Arrays.asList("-Dtycho.mode=maven", 
            "org.eclipse.tycho:tycho-versions-plugin:set-version", 
            "-DgenerateBackupPoms=false", 
            version) );
    try {
        result = invoker.execute( request );
    } catch (MavenInvocationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return result;
}