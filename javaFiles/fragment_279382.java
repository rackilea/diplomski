private RootItem rootItem; /* Initialize this field e.g. in the module's constructor */

@Provides
RootItem provideRootItem() {
    return rootItem;
}

@Provides
SubItemType1 provideSubItemType1() {
    return rootItem.sub1;
}

@Provides
SubItemType2 provideSubItemType2() {
    return rootItem.sub1.sub2;
}