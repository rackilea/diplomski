public static String current_parent;
public void startElement(String namespaceURI, String localName, 
            String qName, Attributes atts) {
    if (localName.equals("news") {
          current_parent = "news";
        // Do your code with news.
        return;
    }
    else  if (localName.equals("category") {
          current_parent = "category";
        // Do your code with category.
        return;
    }
     else  if (localName.equals("category_id") {
         if(current_parent.equals("category")
            {
        // Do your code with category's category_id.
             }else if(current_parent.equals("news")
               {
        // Do your code with news's category_id.
             }
        return;
    }
}