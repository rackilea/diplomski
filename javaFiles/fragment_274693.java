// ...
final BeanItemContainer<Status> container = new BeanItemContainer<>(Status.class);
container.addAll(EnumSet.allOf(Status.class));
cStatus.setContainerDataSource(container);
cStatus.setItemCaptionPropertyId("caption");
basicContent.addComponent(cStatus);
// ...