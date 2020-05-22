@Component(value="primefacesPicklistConverter")
public class PrimefacesPicklistConverter implements Converter {

        public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
            Object ret = null;
            if (arg1 instanceof PickList) {
                Object dualList = ((PickList) arg1).getValue();
                DualListModel<?> dl = (DualListModel<?>) dualList;
                for (Object o : dl.getSource()) {
                    String id = "";
                    if (o instanceof Jbtit) {
                        id += ((Jbtit) o).getId();
                    }
                    if (arg2.equals(id)) {
                        ret = o;
                        break;
                    }
                }
                if (ret == null)
                    for (Object o : dl.getTarget()) {
                            String id = "";
                            if (o instanceof Jbtit) {
                                id += ((Jbtit) o).getId();
                            }
                        if (arg2.equals(id)) {
                            ret = o;
                            break;
                        }
                    }
            }
            return ret;
        }

        public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
            String str = "";
            if (arg2 instanceof Jbtit) {
                str = "" + ((Jbtit) arg2).getId();
            }
            return str;
        }