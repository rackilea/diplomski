public List<IContentWidget> getMenuItems(String zone) {
    if(zone == null){
        return Collections. < IContentWidget > emptyList();
    }
    List<IContentWidget> widgets = new ArrayList<IContentWidget>();
    List<IPersistentEntityInstance> instances = getWidgetsByZone(zone);
    for (IPersistentEntityInstance instance : instances) {
        IContentWidget contentWidget = (IContentWidget) instance;
        if (contentWidget.getZones() == null || contentWidget.getZones().contains(RESPONSIVE_VISIBLE)) {
           continue;
        }
        // Add widget only if the current user has read permission on the entity.
        if (contentWidget.getTargetItemScreen() == null ||
            contentWidget.getTargetListScreen()== null) {
            widgets.add(contentWidget);continue;
        }
        if (isAccessible(contentWidget)) {
             widgets.add(contentWidget);
        }


    }
}
Collections.sort(widgets, new Comparator<IContentWidget>() {

    public int compare(IContentWidget o1, IContentWidget o2) {
        return o1.getOrderNum() - o2.getOrderNum();
    }

});
return widgets;
}