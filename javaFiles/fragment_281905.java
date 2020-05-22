docFactory = DocumentBuilderFactory.newInstance();
docBuilder = docFactory.newDocumentBuilder();
doc = docBuilder.parse("/home/riddhish/developerworkspace/SplitString/src/com/updatexmlwithjava/one.xml");           
traversal = (DocumentTraversal) doc;
a = doc.getDocumentElement();
iterator = traversal.createNodeIterator(a, NodeFilter.SHOW_ELEMENT, null, true);            
for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
      Element e = (Element) n;                
          if ("LinearLayout".equals(e.getTagName())) {
                if(e.getAttribute("android:id").equals("@+id/linearLayout1")){
                        if(flag==true){
                            System.out.println(""+e.getAttribute("android:visibility"));
                            e.setAttribute("android:visibility", "gone");
                        }                           
                }                    
          } 
}