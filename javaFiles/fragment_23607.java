@Name("stringTrimConverter")
@BypassInterceptors
@Converter
public class StringTrimConverter implements javax.faces.convert.Converter {

    public Object getAsObject(FacesContext context, UIComponent cmp, String value) {

        if(StringUtils.isBlank(value)) {
            return null;
        } else {
            return value;
        }
    }

    public String getAsString(FacesContext context, UIComponent cmp, Object value) {

        if(value != null) {
            return value.toString().trim();
        } 
        return null;
    }

}