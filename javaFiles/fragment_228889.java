public class MyWADLGEnerator extends WadlGeneratorApplicationDoc {
@Override
public Method createMethod(org.glassfish.jersey.server.model.Resource ar, ResourceMethod arm) {
    Method method = super.createMethod(ar, arm);

    Annotation[] annotations = arm.getInvocable().getDefinitionMethod().getAnnotations();