public void characters(char[] ch, int start, int length)
            throws SAXException
    {
              if(in_ThisTag){
                     myobj.setName(new String(ch,start,length))
              }
    }