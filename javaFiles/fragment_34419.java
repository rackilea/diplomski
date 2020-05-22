public class GraphPhaseListener implements PhaseListener {
  private TopologyModel topoModel;

  private PhaseId phaseId = PhaseId.RENDER_RESPONSE;

  @Override
  public void beforePhase(PhaseEvent event) {          
     FacesContext context = event.getFacesContext();
     Object obj = context.getExternalContext().getRequest();
     if(!(obj instanceof HttpServletRequest)) {
         return;
     }
     HttpServletRequest request = (HttpServletRequest) obj;
     if(!("true").equals(request.getHeader("networkAjax")) || !request.getMethod().equals("POST")) {
         return;
     }


    Map<String, Object> sessionMap = event.getFacesContext().getExternalContext().getSessionMap();
    Object object = sessionMap.get(EnhancedGraphRenderer.GRAPH_TOPOLOGIE_KEY);
    if(object == null || !(object instanceof TopologyModel)) {
        return;
    }
    topoModel = (TopologyModel) object;
    String graphAction = request.getHeader("graphAction");
    String actionResponse = "";
    if(graphAction==null) {
        return;
    }
    switch(graphAction) {
        case "getNetwork":
            actionResponse = topoModel.getJsonNetwork();
        break;
        case "getNodeTypes":
            actionResponse = topoModel.getJsonNodeTypes();
            //actionRespoonse = topoModel.getFromAction("{node_type:switch, node_id: 2, request: children}")
        break;
        default:
            actionResponse = "{}";
    }

    HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
    try {
        PrintWriter output = response.getWriter();
        output.print(actionResponse);
        context.responseComplete();
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

  }

  @Override
  public void afterPhase(PhaseEvent arg0) {

  }

  @Override
  public PhaseId getPhaseId() {
      return phaseId;
  }
}