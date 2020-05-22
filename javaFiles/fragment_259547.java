Element root = doc.getRootElement();
    List children = root.getChildren();     
    out.println(root);  
    if (children != null)
    {
       for (Element child : children) 
       {
         out.println(child.getAttributeValue( "Title" ));
       }
    }