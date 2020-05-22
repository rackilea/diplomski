void iterateContainer() {
    for(Object rootItemId : myContainer.rootItemIds()) {
        Item rootItem = myContainer.getItem(rootItemId);
        System.out.println(rootItem.getItemProperty(myLabelProperty).getValue());

        iterateChildren(rootItemId, 1);
    }
}

void iterateChildren(Object parentItemId, int indent) {

    for(Object childItemId : myContainer.getChildren(parentItemId)) {
        Item childItem = myContainer.getItem(childItemId);

        for(int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println(childItem.getItemProperty(myLabelProperty).getValue());

        if(myContainer.hasChildren(childItemId)) {
            iterateChildren(childItemId, indent+1);
        }
    }

}