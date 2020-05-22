public static UIComponent create(FacesContext fc, Component component) {
    if (component instanceof Row)
        return create(fc, (Row)component);
    else if (component instanceof Column)
        return create(fc, (Column)component);
    // include other types, and lastly
    else
        throw new UnsupportedOperationException("Method not yet implemented for class: " + component.getClass().getName());
}