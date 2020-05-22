@FacesConverter(value = "modePayementConvertor", forClass = IModePayementDao.class)
public class ModePayementConverter implements Converter {
@Override
public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
    Integer target = new Integer(arg2);
/**this use hibernate change it if u like **/
    Session session = ConnectionDb.getInstance().openSession();
    IModePayementDao modePayement= (IModePayementDao) session.get(IModePayementDao.class, target);
    session.close();
    return modePayement;
}

@Override
public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
    try {
        return ((IModePayementDao) arg2).getId().toString();
    }
    catch (NullPointerException ex) {
        return "";
    }
}}