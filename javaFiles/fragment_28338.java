private Foo customGroup;

private synchronized Foo getCustomGroup() {
    if(customGroup == null) {
        customGroup = grpDao.fetchCustomGroup();
    } 
    return customGroup;
}