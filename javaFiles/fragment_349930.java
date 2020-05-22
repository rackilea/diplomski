@FacesConverter(forClass=Status.class)
public class URLConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return someStatusDAO.findById(Long.valueOf(value));
        } catch (SomeException e) {
            throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Status", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Status) value).getId());
    }

}