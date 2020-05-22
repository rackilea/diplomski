StatefulKnowledgeSession ksession= createKSession();   
ksession.fireAllRules(new AgendaFilter() {
  public boolean accept(Activation activation) {
    Map<String, Object> metaData = activation.getRule().getMetaData();
    if (metaData.containsKey("LegalRequirement")) {
      System.out.println(metaData.get("LegalRequirement"));
    }
    return true;
  }
});