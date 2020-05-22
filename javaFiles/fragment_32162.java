public String logout() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    if (session != null) {
        session.invalidate();
    }
    user = null; // reset user
    // optional: addSuccessMessage

    return "login";
}