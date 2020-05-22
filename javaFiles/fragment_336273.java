private final String projectName;
private final NodeInfo node;
private CollectorsListHolder collectorsListHolder;

@Inject
public CollectorsRunner(@Assisted String projectName, @Assisted NodeInfo node) {
    this.projectName = projectName;
    this.node = node;
}

@Inject
void injectCollectorsListHolderFactory(CollectorsListHolderFactory factory) {
    this.collectorsListHolder = factory.create(projectName, node);
}