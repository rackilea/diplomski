@FacesConverter("CustomCalendarConverter")
public class CalConverter implements Converter{

@Override
public Object getAsObject(FacesContext context, UIComponent component, String value) {
    if(value != null && !value.toString().isEmpty()){
        try {
            String pattern = (String) component.getAttributes().get("pattern");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new SimpleDateFormat(pattern).parse(value));
            return calendar;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    return null;
}

@Override
public String getAsString(FacesContext context, UIComponent component, Object value) {

    if(value != null && !value.toString().isEmpty()){
        Calendar cal = (Calendar) value;
        String pattern = (String) component.getAttributes().get("pattern");
        return new SimpleDateFormat(pattern).format(cal.getTime());
    }
        else return null;
    }
}