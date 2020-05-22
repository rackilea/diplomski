package my;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static Map<String, String> propsToMap(Properties props,
            String idPatternString, String valuePatternString) {

        Map<String, String> map = new HashMap<String, String>();

        Pattern idPattern = Pattern.compile(idPatternString);

        for (Enumeration<?> en = props.propertyNames(); en.hasMoreElements();) {
            String key = (String) en.nextElement();
            String mapKey = (String) props.getProperty(key);

            if (mapKey != null) {
                Matcher idMatcher = idPattern.matcher(key);
                if (idMatcher.matches()) {

                    String valueName = valuePatternString.replace("{idGroup}",
                            idMatcher.group(1));
                    String mapValue = props.getProperty(valueName);

                    if (mapValue != null) {
                        map.put(mapKey, mapValue);
                    }
                }
            }
        }

        return map;
    }
}