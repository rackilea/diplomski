You can use the following code to store the months in a hash map.   

 import java.util.HashMap;
    import java.util.Iterator;
    import java.util.Map;
    import java.util.Set;
    import java.lang.String;

    public class strings {
        public static void main(String [] args){
            String text = "jan,feb,march,april";
            String[] keyValue = text.split(",");
            Map<Integer, String> myMap = new HashMap<Integer, String>();
            for (int i=0;i<keyValue.length;i++) {
                myMap.put(i, keyValue[i]);
            }
             Set keys = myMap.keySet();
                Iterator itr = keys.iterator();

                Integer key;
                String value;
                while(itr.hasNext())
                {
                    key = (Integer)itr.next();
                    value = (String)myMap.get(key);
                    System.out.println(key + " - "+ value);
                }
        }
    }

The out put will be-
0 - jan
1 - feb
2 - march
3 - april


Further you can perform the check that you want