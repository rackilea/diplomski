public void publishImage() throws Exception {

    ResourceDescriptor rd = new ResourceDescriptor();       
    rd.setName("coffeepicture");
    rd.setLabel("Coffee picture from java");
    rd.setResourceType(ResourceDescriptor.TYPE_IMAGE);
    rd.setMainReport(true);
    rd.setParentFolder("/Samples");
    rd.setUriString(rd.getParentFolder() + rd.getName());
    rd.setWsType(ResourceDescriptor.TYPE_IMAGE);
    rd.setIsNew(true);
    rd.setHasData(true);

    File image = new File("/home/coffee.jpg");

    client.addOrModifyResource(rd, image);
}