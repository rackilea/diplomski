public void visualizarPartidaDetalle() {
    Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    visualizarPartidaDetalle(params.get("refNumPart"), params.get("estado"));
}

public void visualizarPartidaDetalle(String refNumPart, String estado) {
    PartidaDirectaResultBean result = new PartidaDirectaResultBean();
    result.setRefNumPart(refNumPart);
    result.setEstado(estado);
    // Etc...
}