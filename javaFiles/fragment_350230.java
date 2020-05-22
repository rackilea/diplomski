private EntityManager getEntityManager() {
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();
    HttpServletRequest request = (HttpServletRequest) ec.getRequest();
    EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

    return manager;
}