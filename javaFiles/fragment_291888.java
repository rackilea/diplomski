public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
    if (value == null || value.length() == 0) {
        return null;
    }

    Integer id = getKey(value);
    Matches matches = getItSomehowBasedOn(id);
    return matches;
}