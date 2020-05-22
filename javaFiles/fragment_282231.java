package reports;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Arrays;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRException;

public class CollectionDataSource implements JRDataSource {
    private Iterator iterator = null;
    private Object current = null;

    public CollectionDataSource(Collection col) {
        if (col != null) {
            iterator = col.iterator();
        }
    }

    public CollectionDataSource(Object array[]) {
        this(Arrays.asList(array == null ? new Object[0] : array));
    }

    public boolean next() throws JRException {
        if (iterator == null || !iterator.hasNext()) {
            return false;
        } else {
            current = iterator.next();
            return true;
        }
    }

    public Object getFieldValue(JRField field) throws JRException {
        if ("this".equals(field.getName())) {
            return current;
        } else if (current == null) {
            return null;
        } else {
            Class<?> clazz = current.getClass();
            char chars[] = field.getName().toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            String name = new String(chars);
            Method method = null;
            try {
                method = clazz.getMethod("get" + name);
            } catch (NoSuchMethodException e) {
                if (field.getValueClass() == Boolean.class) {
                    try {
                        method = clazz.getMethod("is" + name);
                    } catch (NoSuchMethodException e1) {
                    }
                }
            }
            if (method == null) {
                throw new JRException("No getter for field " + name);
            }
            try {
                return method.invoke(current);
            } catch (Exception e) {
                throw new JRException("Exception in getter of " + name, e);
            }
        }
    }
}