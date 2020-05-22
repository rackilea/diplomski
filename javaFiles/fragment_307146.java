PDPage imported = getDestinationDocument().importPage(page);
imported.setCropBox(page.getCropBox());
imported.setMediaBox(page.getMediaBox());
// only the resources of the page will be copied
imported.setResources(page.getResources());
imported.setRotation(page.getRotation());
// remove page links to avoid copying not needed resources 
processAnnotations(imported);