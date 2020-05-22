protected MyActionClass()
{
super(null, ComponentManager.getComponentInstanceOfType(BulkEditBeanSessionHelper.class));

genericBulkWatchOperation = ComponentAccessor.getBulkOperationManager().getOperation(NAME_KEY);
}