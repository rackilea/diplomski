PDDocumentCatalog catalog = doc.getDocumentCatalog();
PDPage page = doc.getPage(0); // zero-based; you can also put another number to jump to a specific existing page
PDPageXYZDestination dest = new PDPageXYZDestination();
dest.setPage(page);
dest.setZoom(0.75f);
dest.setLeft((int) page.getCropBox().getLowerLeftX());
dest.setTop((int) page.getCropBox().getUpperRightY());
PDActionGoTo action = new PDActionGoTo();
action.setDestination(dest);
catalog.setActions(null);
catalog.setOpenAction(action);
doc.save(...);