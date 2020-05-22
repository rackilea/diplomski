public String addUser() throws NoSuchAlgorithmException {
   HttpSession currentSession = request.getSession();
        Map currentSession = ActionContext.getContext().getSession();
        User u = new User();
        u.setUname(getUserName());
        u.setPassword(StringHash(getUserPass()));
        u.setUtype(getUserType());
        plResponse = iUserDAO.addUser(u);
        setActionMessage(plResponse.getMessage());
   currentSession.setAttribute("actionMessage", this.actionMessage);
        currentSession.put("actionMessage", getActionMessage());
        return SUCCESS; 
    }