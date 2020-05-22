@XmlRootElement
private static class RequestWrapper {
    @XmlElement
    private ArrayList<String> msgIdList;
    @XmlElement
    private String action;

    public ArrayList<String> getMsgIdList() {
        return msgIdList;
    }
    public void setMsgIdList(ArrayList<String> msgIdList) {
        this.msgIdList = msgIdList;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    } 
    public RequestWrapper() {

    }
}

@POST   
@Path("updatemessages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON +"; charset=UTF-8")
public Response updateMessages( RequestWrapper requestData,
                                @CookieParam("rgsid") String c_sid, 
                                @Context HttpServletRequest httpservletreq) {
//...}