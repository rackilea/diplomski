public void navigateTo(String href) {
        try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("MYSERVERADDRESS" + href);
    } catch (IOException ex) {
    }
}