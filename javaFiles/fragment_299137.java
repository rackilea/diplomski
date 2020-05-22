import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public final class InjectUtil<T> {
    // private static final Logger LOGGER =
    // LoggerFactory.getLogger(InjectUtil.class);

    public static <T> T converter2Obj(String source, Class<T> tClass) {
        T t = null;

        try {
            t = tClass.newInstance();
            Map<String, Object> params = new HashMap<String, Object>();
            if (source != null && source.length() > 0) {
                String[] fields = source.split("&");
                for (String field : fields) {
                    String[] fieldKeyValue = field.split("\\=");
                    String fieldKey = fieldKeyValue[0];
                    String fieldValue = fieldKeyValue[1];

                    if (params.containsKey(fieldKey)) {

                        //the key does not exist as yet
                        Object keyValueRetrieved = params.get(fieldKey);
                        if (keyValueRetrieved instanceof String) {
                            //key exists , it is single value that has been added now.
                            //change that now to a list to add more values
                            ArrayList<String> values = new ArrayList<String>();
                            values.add(keyValueRetrieved.toString());
                            values.add(fieldValue);
                            params.put(fieldKey, values);
                        } else {
                            //key exists , it is a list already. Add more values
                            ((ArrayList<String>) keyValueRetrieved).add(fieldValue);
                        }
                    } else {
                        params.put(fieldKey, fieldValue);
                    }

                }
            }
            BeanUtils.populate(t, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------");
        System.out.println(t.toString());
        System.out.println("--------------------------------------------");
        return t;
    }
}