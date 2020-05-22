private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
...
public String doSend(){
    Server server = new Server();
    server.setId(id);
    server.setName(name);    
    sessionMap.put("serverObject", server);
    return("send-page");
}