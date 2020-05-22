@Override
protected void onJunctionLinkClicked(final AjaxRequestTarget target, final TreeNode node) {
    super.onJunctionLinkClicked(target, node);
    skipNextRowClick();
}

@Override
protected void onNodeLinkClicked(final AjaxRequestTarget target, final TreeNode node) {
    super.onNodeLinkClicked(target, node);
    skipNextRowClick();
}