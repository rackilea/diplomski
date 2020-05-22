BlockBox root = renderer.getRootBox();
 List  pageList = root.getLayer().getPages() 
 PageBox page = (PageBox)pageList.get(2);
 List childBoxList = page.getChildren();
 Box childBox = (Box)childBoxList.get(0);
 // etc... until you locate your table