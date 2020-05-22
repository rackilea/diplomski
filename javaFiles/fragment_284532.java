public class NERPost {

      public String convertXML (String input) {
      String nerOutput = input;
      try {
           DocumentBuilderFactory docBuilderFactory = 
           DocumentBuilderFactory.newInstance();
           DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           InputSource is = new InputSource();            
           is.setCharacterStream(new StringReader(nerOutput));       
           Document doc = docBuilder.parse(is);

        // normalize text representation
        doc.getDocumentElement ().normalize ();
        NodeList listOfDummies = doc.getElementsByTagName("dummy");


        for(int s=0; s<listOfDummies.getLength() ; s++){
            Node firstDummyNode = listOfDummies.item(s);
            if(firstDummyNode.getNodeType() == Node.ELEMENT_NODE){
               Element firstDummyElement = (Element)firstDummyNode;

         //Convert each entity label --------------------------------

          //TimeStamp
               String ts = "<TimeStamp>";
               Boolean foundTs;

               if (foundTs = nerOutput.contains(ts)) {                    
           NodeList timeStampList = firstDummyElement.getElementsByTagName("TimeStamp");

          //do it recursively  
                for (int i=0; i<timeStampList.getLength(); i++) {       
                Node firstTimeStampNode = timeStampList.item(i);
                Element timeStampElement = (Element)firstTimeStampNode;
                NodeList textTSList = timeStampElement.getChildNodes();
                String timeStampOutput = ((Node)textTSList.item(0)).getNodeValue().trim();
                System.out.println ("<TimeStamp>" + timeStampOutput + "</TimeStamp>\n")
                   } //end for
                }//end if
             //other XML tags
              //.....
               }//end if
              }//end for
           }
            catch...
              }//end try
                }}