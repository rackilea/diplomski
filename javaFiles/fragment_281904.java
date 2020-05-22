boolean flag=false;
for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
       Element e = (Element) n;                
            if ("int".equals(e.getTagName())) {
                if(e.getAttribute("name").equals("linearLayout1")){
                        if(e.getAttribute("value").equals("8"))
                            flag=true;                      
                    }                    
            } 
}