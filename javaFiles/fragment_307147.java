private void processAnnotations(PDPage imported) throws IOException
{
    List<PDAnnotation> annotations = imported.getAnnotations();
    for (PDAnnotation annotation : annotations)
    {
        if (annotation instanceof PDAnnotationLink)
        {
            PDAnnotationLink link = (PDAnnotationLink)annotation;   
            PDDestination destination = link.getDestination();
            if (destination == null && link.getAction() != null)
            {
                PDAction action = link.getAction();
                if (action instanceof PDActionGoTo)
                {
                    destination = ((PDActionGoTo)action).getDestination();
                }
            }
            if (destination instanceof PDPageDestination)
            {
                // TODO preserve links to pages within the splitted result  
                ((PDPageDestination) destination).setPage(null);
            }
        }
        // TODO preserve links to pages within the splitted result  
        annotation.setPage(null);
    }
}