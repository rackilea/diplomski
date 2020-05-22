import javax.faces.convert.FacesConverter;
import entity.AbstractEntity;

@FacesConverter("entity")
public class EntityConverter extends AbstractConverter {

    @Override
    public String getConversionId(Object value) {

        if (value instanceof AbstractEntity) {
            AbstractEntity entity = (AbstractEntity) value;
            StringBuilder sb = new StringBuilder();
            sb.append(entity.getClass().getSimpleName());
            sb.append("@");
            sb.append(entity.getId());
            return sb.toString();
        }

        return null;
    }
}