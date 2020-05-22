if(node.getNodeType() == Node.ELEMENT_NODE){
    Element e = (Element) node;
    NodeList resultNodeList = e.getElementsByTagName("con");           

    if(!e.hasAttribute("idref")){
        if(resultNodeList.getLength() == 2){
            Element nameElement = (Element) resultNodeList.item(1); 
            if(!nameElement.hasAttribute("idref"))
                 System.out.println("Context ID Ref : "+null);
            else    
                 System.out.println("Context ID Ref :"+nameElement.getAttribute("idref"));
        }else {
            Element nameElement = (Element) resultNodeList.item(0);   
            if(!nameElement.hasAttribute("idref"))
                 System.out.println("Context ID Ref : "+null);
            else    
                 System.out.println("Context ID Ref :"+nameElement.getAttribute("idref"));
        }
    }
}