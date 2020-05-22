QueryAgentsOnLocation ca = new QueryAgentsOnLocation();
ca.setLocation(...); // here is the information about you ontainer
Action actExpr = new Action(myAgent.getAMS(), ca);

ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
request.addReceiver(myAgent.getAMS());
request.setOntology(JADEManagementOntology.getInstance().getName());
request.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
myAgent.getContentManager().fillContent(request, actExpr);
myAgent.send(request);