@Component(role = AbstractMavenLifecycleParticipant.class, hint = "my-dep")
public class DependencyLifecycleParticipant extends AbstractMavenLifecycleParticipant 
{

@Override
public void afterSessionStart(MavenSession session) throws MavenExecutionException {
    session.getUserProperties().setProperty("MyVersion", "1.2.3");
}