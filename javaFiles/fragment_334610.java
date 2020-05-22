else if (qName.equalsIgnoreCase("Status")) {
    object = new Status();
    object.id = attributes.getValue("ID");
    object.cssClass = attributes.getValue("CssClass");
    object.isActive = attributes.getValue("IsActive");
    object.description = attributes.getValue("Description");
}
else if (qName.equalsIgnoreCase("StatusType")) {
    object.typeId = attributes.getValue("ID");
    //etc, and maybe the StatusType should be a nested class of Status and stored in array field
}