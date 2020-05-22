@Override
public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
    if (modelValue == null || ((String) modelValue).isEmpty()) {
        return null;
    }

    String string = (String) modelValue;
    return new StringBuilder()
        .append(Character.toTitleCase(string.charAt(0)))
        .append(string.substring(1))
        .toString();
}