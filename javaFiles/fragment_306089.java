public class CustomImplementsAnnotationHandler implements OverrideImplementsAnnotationsHandler {

  @Override
  public String[] getAnnotations(Project project) {
    return new String[]{};
  }

  @Override
  public String[] annotationsToRemove(Project project, @NotNull String fqName) {
    return new String[] {"package.RpcDataTable"};
  }
}