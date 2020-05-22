@Override
public String getAsString(FacesContext context, 
                              UIComponent component, Object value) {
    if (value == null || value.equals("")) {
        return "";
    } else {
        return String.valueOf(((Player)value).getStringID()); 
                //or what ever the id is
    }
}