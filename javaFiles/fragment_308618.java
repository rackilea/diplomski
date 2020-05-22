<%!
    void displayRecursively(JspWriter out, KnowledgeElement ke, ExtendsRelationshipService ers){
        List<ExtendsRelationship> erList = null;
        out.print(ke.getName());
        out.println("<br />");
        try {
            erList = ers.findIncomingExtendsKERelationships(ke);
        } catch (Exception e) {}
        if (erList!=null){
            for (ExtendsRelationship er : erList){
                KnowledgeElement startKe = er.getStartKE();
                displayRecursively(out, startKe,ers);
            }
        }
    } 
  %>