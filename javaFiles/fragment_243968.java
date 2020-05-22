@ManagedBean
@ApplicationScoped
@SuppressWarnings({ "rawtypes", "unchecked" }) // We don't care about BaseEntity's actual type here.
public class BaseEntityConverter implements Converter {

    @EJB
    private BaseService baseService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }

        if (modelValue instanceof BaseEntity) {
            Number id = ((BaseEntity) modelValue).getId();
            return (id != null) ? id.toString() : null;
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid User", modelValue)), e);
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            Class<?> type = component.getValueExpression("value").getType(context.getELContext());
            return baseService.find((Class<BaseEntity<? extends Number>>) type, Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid ID of BaseEntity", submittedValue)), e);
        }
    }

}