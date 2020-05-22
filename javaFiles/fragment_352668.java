public String getGraph(){

       // SessionInfo sessionData = (SessionInfo)getCurrentRowObject();
      BasicDynaBean sessionData=(BasicDynaBean) getCurrentRowObject();

        String showGraph  = "<a href=\"javascript:send("+ sessionData.get("startdatetime")+","+ sessionData.get("enddatetime")+")\"> show graph </a>";

   //  String showGraph  = "<a href=\"javascript:send()\"> show graph </a>";

        return showGraph;
    }