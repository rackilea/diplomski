MessageTemplate mt = MessageTemplate.MatchConversationId("G");;
ACLMessage msg = myAgent.receive(mt);
if (msg != null) {
  // Process it
  ...
} else {
   block();
}