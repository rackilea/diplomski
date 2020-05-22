@Override
protected void populateTreeItem(final WebMarkupContainer item, final int level) {
    super.populateTreeItem(item, level);
    item.add(new AjaxEventBehavior("onclick") {
        @Override
        protected void onEvent(final AjaxRequestTarget target) {
            final TreeNode node = ((TreeNode) item.getDefaultModelObject());
            rowClickSelect(node);
        });
    }
};