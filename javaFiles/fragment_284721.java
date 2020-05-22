package stackoverflow.questions.q19817221;

import java.util.*;

import com.google.gson.Gson;

public class Q19817221 {

    public class ListWrapper {

        private Map list;
        private Map status;
        private Map batch;

        private Object extractValue(Map m) {
            return m.get("$");
        }

        public Integer getBatch() {
            return Integer.valueOf( (String) extractValue(batch));
        }

        public Object getValueFromList(String key) {
            try {
                Map m = (Map) list.get(key);
                if (m != null)
                    return extractValue(m);
            } catch (Exception e) {
                return list.get(key);
            }
            return null;
        }

        public Object getValueFromList(String secondLevelKey, String key) {

            Map secondLevelMap = (Map) list.get(secondLevelKey);
            try {
                Map m = (Map) secondLevelMap.get(key);
                if (m != null)
                    return extractValue(m);
            } catch (Exception e) {
                return list.get(key);
            }
            return null;

        }
    }

    public class Container {
        public ListWrapper ListWrapper;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
       String json = "{\"ListWrapper\":{\"batch\":{\"$\":\"0\"},\"list\":{\"@xmlns\":{\"xsi\":\"http://www.w3.org/2001/XMLSchema-instance\"},\"@xsi:type\":\"fidsUsers\",\"createdBy\":{\"$\":\"administrator\"},\"createdWhen\":{\"$\":\"2013-02-25T17:29:19-05:00\"},\"endDate\":{\"$\":\"2016-10-28T00:00:00-04:00\"}," +
            "\"isDisabled\":{\"$\":\"N\"},\"previousPasswords\":{\"$\":\"HXQDa4WxTdBmZtvhMVTgnw==@@@@zW6bdHkKdMN2p6CgRNjNHA==@@@@Sim7JN3kaHoXnh3KUS2++Q==@@@@Emz7zU0Wrm0lyb/K522O5A==@@ZirxzRl28JqfjOzIaMzAog==\"}," +
            "\"primaryKey\":{\"$\":\"David\"},\"pswdChgDate\":{\"$\":\"2013-07-12T08:27:46-04:00\"},\"pswdCount\":{\"$\":\"0\"},\"roleId\":{\"$\":\"Admin\"},\"roleIdFidsRoles\":{\"globalAccess\":{\"$\":\"Y\"},\"primaryKey\":{\"$\":\"Admin\"},\"roleDesc\":{\"$\":\"Administrator\"},\"roleId\":{\"$\":\"Admin\"}," +
            "\"updatedBy\":{\"$\":\"David\"}},\"startDate\":{\"$\":\"1992-07-28T00:00:00-04:00\"},\"updatedBy\":{\"$\":\"David\"},\"updatedWhen\":{\"$\":\"2013-10-02T10:46:31-04:00\"},\"userId\":{\"$\":\"David\"},\"userName\":{\"$\":\"David3\"},\"userPassword\":{\"$\":\"HXQDa4WxTdBmZtvhMVTgnw==\"}},\"status\":{\"$\":\"Success\"}}}";


       Container c = new Gson().fromJson(json, Container.class);
       ListWrapper lw = c.ListWrapper;

       System.out.println("batch:" + lw.getBatch());
       System.out.println("createdBy:" + lw.getValueFromList("createdBy"));
       System.out.println("@xsi:type: " + lw.getValueFromList("@xsi:type"));

       System.out.println("roleIdFidsRoles\\primaryKey: " + lw.getValueFromList("roleIdFidsRoles", "primaryKey"));



    }
}