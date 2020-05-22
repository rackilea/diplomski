@Component("selectOneListBoxConverter")
@FacesConverter(forClass = FarmsController.class, value = "selectOneListBoxConverter")
public class SelectOneListBoxConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {

        MajorCrop dl = new MajorCrop();

        String[] values = value.split("\\(");
        String name = "";
        for (int i = 0; i < values.length - 1; i++) {
            name += values[i];
        }

        dl.setName(name.substring(0, name.length() - 1));
        dl.setRotations(values[values.length - 1].substring(0,
                values[values.length - 1].length() - 1));

        return dl;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        return value.toString();
    }

}