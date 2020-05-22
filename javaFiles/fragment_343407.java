// load the data from the GDST file, for example:
String decisionTableXml = new String ( 
  Files.readAllBytes( 
    Paths.get("./someDecisionTable.gdst") ) );

// parse the table model
GuidedDecisionTable52 model = GuidedDTXMLPersistence.getInstance().unmarshal( decisionTableXml );

// compile it into drools rules
String droolsRules = GuidedDTDRLPersistence.getInstance().marshal( model );

// next, save droolsRules into a file and/or load it into drools as a normal rule