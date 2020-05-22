public String login() {
    User user = userDAO.find(username, password);
    FacesContext context = FacesContext.getCurrentInstance();

    if (user != null) {
        context.getExternalContext().getSessionMap().put("user", user);
        return "user?faces-redirect=true";
    } else {
        context.addMessage("username", new FacesMessage("Invalid UserName and Password"));
        return null;
    }
}