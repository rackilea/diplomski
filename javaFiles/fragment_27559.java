import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public abstract class AbstractConverter implements Converter {

    private static final String key = "any.key.you.want";

    protected Map<String, Object> getViewMap(FacesContext context) {
        Map<String, Object> viewMap = context.getViewRoot().getViewMap();
        Map<String, Object> idMap = (Map) viewMap.get(key);
        if (idMap == null) {
            idMap = new HashMap<String, Object>();
            viewMap.put(key, idMap);
        }
        return idMap;
    }

    @Override
    public final Object getAsObject(FacesContext context, UIComponent c,String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return getViewMap(context).get(value);
    }

    @Override
    public final String getAsString(FacesContext context, UIComponent c, Object value) {
        if (value != null) {
            String id = getConversionId(value);
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Object can't be converted.");
            }
            getViewMap(context).put(id, value);
            return id;
        }
        return null;
    }

    public abstract String getConversionId(Object value);
}