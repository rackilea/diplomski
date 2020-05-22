public static Set<String> getClientBehaviorRenderIds(UIComponent component, String behaviorName) {
    Set<String> clientBehaviorRenderIds = new HashSet<String>();

    if (!(component instanceof ClientBehaviorHolder)) {
        return clientBehaviorRenderIds;
    }

    List<ClientBehavior> clientBehaviors = ((ClientBehaviorHolder) component).getClientBehaviors().get(behaviorName);

    if (clientBehaviors == null) {
        return clientBehaviorRenderIds;
    }

    for (ClientBehavior clientBehavior : clientBehaviors) {
        if (clientBehavior instanceof AjaxBehavior) {
            clientBehaviorRenderIds.addAll(((AjaxBehavior) clientBehavior).getRender());
        }
    }

    return clientBehaviorRenderIds;
}