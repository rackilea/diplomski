if (action instanceof PDActionGoTo) 
{
     PDPageDestination pageDestination = null;
     PDPage page = null;
     PDDestination destination = ((PDActionGoTo)action).getDestination();
     if (destination instanceof PDPageDestination)
     {
         pageDestination = (PDPageDestination) destination;
         page = pageDestination.getPage();
     }
     else if (destination instanceof PDNamedDestination)
     {
         pageDestination = doc.getDocumentCatalog().findNamedDestinationPage((PDNamedDestination) destination);
         if (pageDestination == null)
         {
             return null;
         }
         page = pageDestination.getPage();
     }
     else
     {
         // error handling
     }
}