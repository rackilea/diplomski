public class UiResourceFactory extends MyResourceFactory {

  private FileScope scope;

  @Inject
  public UiResourceFactory(Injector injector) {
    super(injector);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Resource createResource(URI uri) {
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    IFile file = root.getFile(new Path(uri.toPlatformString(true)));
    scope.enter(file);
    try {
      return super.createResource(uri);
    } finally {
      scope.exit();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setInjector(Injector injector) {
    super.setInjector(injector);
    scope = getInjector().getInstance(FileScope.class);
  }

}