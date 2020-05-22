public static ArrayList<Element> readSubElements()
   {
       ArrayList<Element> subElements = new ArrayList<>();

        Element root = configs.XMLreaderDOM4J.getDoc().getRootElement();
        for (Iterator it = root.elementIterator(); it.hasNext();){
            Element foo = (Element) it.next();
            if(foo.attributeValue("id").equals("VPP"))
            {
               for (Iterator it2 = foo.elementIterator(); it2.hasNext(); )
               {
                  Element temp = (Element) it2.next();
                   subElements.add(temp);
                   System.out.println(""+temp);
               }
            }
        }

       return subElements;        
   }