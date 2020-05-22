private List<String> getAvailableJobTypes() {
    List<String> types = new ArrayList<String>();
    for ( TopLevelItemDescriptor tliDescriptor : Items.all() ) {
        types.add( tliDescriptor.getDisplayName());
    }
    return types;
}