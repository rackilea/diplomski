public Date getCurrentServerTime() {
    Folder rootFolder = project.getDefaultView().getRootFolder();

    Topic newItem = (Topic) Item.createItem(project.getTypeNames().TOPIC, rootFolder);
    newItem.update();
    newItem.remove();
    newItem.update();
    return newItem.getCreatedTime().createDate();
}