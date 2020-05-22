public static String getAbsoluteClientId(String id) {
    final String clientId = removeRowIndexFromClientId(id);
    FacesContext facesContext = FacesContext.getCurrentInstance();
    final char separator = UINamingContainer.getSeparatorChar(facesContext);        
    StringBuilder idBuilder = new StringBuilder();
    idBuilder.append(separator).append(clientId);
    return idBuilder.toString();        
}

public static String removeRowIndexFromClientId(String id) {
    String clientId = findComponentClientId(id);
    FacesContext facesContext = FacesContext.getCurrentInstance();
    final char separator = UINamingContainer.getSeparatorChar(facesContext);
    final String regex = String.valueOf(separator) + "[0-9]+";
    return clientId.replaceAll(regex, "");
}