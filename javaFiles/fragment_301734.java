if (event.isStartElement()
     && event.asStartElement().getName().getLocalPart().equals(STRING)) {
          if (macro == null) {
               macro = new Macro();
          }
           macro.setName(eventReader.getElementText());
  }