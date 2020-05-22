private boolean isAccessible(IContentWidget contentWidget) {
    boolean isWidgetAccessible = false;
    String permission = contentWidget.getDisplayPermission();
    if (permission != null) {
        return authorizationService.userHasPermission(SecurityHelper.getAuthenticatedUser(),
                permission);
    }
    else {
        IBaseScreen screen = contentWidget.getTargetItemScreen() == null ? contentWidget.getTargetListScreen()
                : contentWidget.getTargetItemScreen();
        // return true when target screen is 'null', this means that target link cannot be secured because it is not
        // associated with any entity
        if (screen == null) {
            return true;
        }
        else {
            IAccessEntry access = authorizationService.getAccessForEntityMetadata(screen.getEntityMetadata());

            // fetching metadata from entityMetadataService again to trigger population of facade
            if (screen instanceof IListScreen && access.getIsReadable()) {
                isWidgetAccessible = true;
            }
            else if (screen instanceof IItemScreen && access.getIsCreatable()) {
                isWidgetAccessible = true;
            }
        }
    }
    return isWidgetAccessible;
}