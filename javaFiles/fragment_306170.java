public static Set<String> getClientBehaviorRenderIds(UIComponent component, String behaviorName) {
    Set<String> clientBehaviorRenderIds = new HashSet<String>();

    if (component instanceof ClientBehaviorHolder) {
        List<ClientBehavior> clientBehaviors = ((ClientBehaviorHolder) component).getClientBehaviors().get(behaviorName);

        if (clientBehaviors != null) {
            for (ClientBehavior clientBehavior : clientBehaviors) {
                if (clientBehavior instanceof AjaxBehavior) {
                    clientBehaviorRenderIds.addAll(((AjaxBehavior) clientBehavior).getRender());
                }
            }
        }
    }

    return clientBehaviorRenderIds;
}