try{ //throws a bunch of XML parsing related exceptions
      XMLInputFactory xFactory = XMLInputFactory.newFactory();
      XMLStreamReader xStream = xFactory.createXMLStreamReader(req.getInputStream());
      //Start skipping tags til you get to the message payload
      for(int nodeCount=0; nodeCount < 3; nodeCount++){
             xStream.nextTag(); //Jump <Envelope/>,<Body/>,<theMessageNode/>   
          }
      //You're now at the level of the actual class; Now unmarshal the payload  

      JAXBContext ctxt  = JAXBContext.newInstance(YourResponseClass.class);
      Unmarshaller um = ctxt.createUnmarshaller();
      JAXBElement<YourResponseClass.class> elem = um.unmarshal(xStream, YourResponseClass.class);             
      YourResponseClass theObj = elem.getValue();

     }
    catch(Exception ex) {

    }