com.day.cq.widget.HtmlLibraryManager clientlibmanager = sling.getService(com.day.cq.widget.HtmlLibraryManager.class);
if(clientlibmanager != null)
{ 
    String[] categoryArray = {"headlibs"};
    java.util.Collection<com.day.cq.widget.ClientLibrary> libs = clientlibmanager.getLibraries(catArray,com.day.cq.widget.LibraryType.JS,false,false);
    for(com.day.cq.widget.ClientLibrary lib : libs) {
        out.write("<script async type=\"text/javascript\" src=\""+lib.getIncludePath(com.day.cq.widget.LibraryType.JS)+"\"></script>");
    }

} else {
         out.write("clientlib manager is null");
  }