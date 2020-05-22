package at.percom.temp.zztests;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtilsBean;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Main main = new Main();
        main.start();
    }

    public void start() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        SampleBean oldSample = new SampleBean("John", "Doe", 1971);
        SampleBean newSample = new SampleBean("John X.", "Doe", 1971);

        SampleBean diffSample = (SampleBean) compareObjects(oldSample, newSample, new HashSet<>(Arrays.asList("lastName")), 10L);
    }

public Object compareObjects(Object oldObject, Object newObject, Set<String> propertyNamesToAvoid, Long deep) {
    return compareObjects(oldObject, newObject, propertyNamesToAvoid, deep, null);
}

private Object compareObjects(Object oldObject, Object newObject, Set<String> propertyNamesToAvoid, Long deep,
        String parentPropertyPath) {
    propertyNamesToAvoid = propertyNamesToAvoid != null ? propertyNamesToAvoid : new HashSet<>();
    parentPropertyPath = parentPropertyPath != null ? parentPropertyPath : "";

    Object diffObject = null;
    try {
        diffObject = oldObject.getClass().newInstance();
    } catch (Exception e) {
        return diffObject;
    }

    BeanMap map = new BeanMap(oldObject);

    PropertyUtilsBean propUtils = new PropertyUtilsBean();

    for (Object propNameObject : map.keySet()) {
        String propertyName = (String) propNameObject;
        String propertyPath = parentPropertyPath + propertyName;

        if (!propUtils.isWriteable(diffObject, propertyName) || !propUtils.isReadable(newObject, propertyName)
                || propertyNamesToAvoid.contains(propertyPath)) {
            continue;
        }

        Object property1 = null;
        try {
            property1 = propUtils.getProperty(oldObject, propertyName);
        } catch (Exception e) {
        }
        Object property2 = null;
        try {
            property2 = propUtils.getProperty(newObject, propertyName);
        } catch (Exception e) {
        }
        try {
            if (property1 != null && property2 != null && property1.getClass().getName().startsWith("com.racing.company")
                    && (deep == null || deep > 0)) {
                Object diffProperty = compareObjects(property1, property2, propertyNamesToAvoid,
                        deep != null ? deep - 1 : null, propertyPath + ".");
                propUtils.setProperty(diffObject, propertyName, diffProperty);
            } else {
                if (!Objects.deepEquals(property1, property2)) {
                    propUtils.setProperty(diffObject, propertyName, property2);
                    System.out.println("> " + propertyPath + " is different (oldValue=\"" + property1 + "\", newValue=\""
                            + property2 + "\")");
                } else {
                    System.out.println("  " + propertyPath + " is equal");
                }
            }
        } catch (Exception e) {
        }
    }

    return diffObject;
}

    public class SampleBean {

        public String firstName;
        public String lastName;
        public int yearOfBirth;

        public SampleBean(String firstName, String lastName, int yearOfBirth) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.yearOfBirth = yearOfBirth;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getYearOfBirth() {
            return yearOfBirth;
        }
    }
}