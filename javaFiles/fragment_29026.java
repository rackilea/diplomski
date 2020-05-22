@Inject
private PageRenderLinkSource renderLinkSource;

public Link getEditLink() {
    return renderLinkSource.createPageRenderLinkWithContext(PersonPage.class, person.getEmployeeNumber());
}