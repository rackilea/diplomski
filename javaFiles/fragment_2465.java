@FacesConverter("filterTypeConverter")
public class TFilterTypeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        FilterTypeBean filterTypeBean = context.getApplication().evaluateExpressionGet(context, "#{filterTypeBean}", FilterTypeBean.class);
        for (TFilterType type : filterTypeBean.listBooleanFilterTypes()) {
            if (type.getFilterTypeName().equals(value)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof TFilterType) {
            return ((TFilterType) value).getFilterTypeName();
        } else {
            return "";
        }
    }
}