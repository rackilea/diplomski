public class TestJSON {

    public static void main(String[] args) throws JSONException {
        String result = "[\n"
                + "  [\"53\",\"54\",\"55\",\"62\",\"63\",\"64\"],\n"
                + "  [\"1133 Budapest Dráva utca 10.\",\"1106 Budapest Örs vezér tere 25.\",\"1106 Budapest Örs vezér tere 25.\",\"1106 Budapest Örs vezér tere 25.\",\"1133 Budapest Dráva utca 10.\",\"1106 Budapest Örs vezér tere 25.\"],\n"
                + "  [\n"
                + "    [\"2016-08-18\",\"15:00:00\"],\n"
                + "    [\"2016-04-08\",\"13:00:00\"],\n"
                + "    [\"2016-04-08\",\"14:00:00\"],\n"
                + "    [\"2016-04-08\",\"10:00:00\"],\n"
                + "    [\"2016-04-08\",\"13:00:00\"],\n"
                + "    [\"2016-04-08\",\"15:00:00\"]\n"
                + "  ]\n"
                + "]";
        JSONArray jArr = new JSONArray(result);
        if (jArr.length() != 0) {
            List ids = fillArray(jArr.getJSONArray(0));
            List places = fillArray(jArr.getJSONArray(1));
            List dates = fillArray(jArr.getJSONArray(2));
            System.out.println(ids);
            System.out.println(places);
            System.out.println(dates);
        }
    }

    private static List fillArray(JSONArray jsonArray) throws JSONException {
        List array = new ArrayList();
        for (int i = 0; i < jsonArray.length(); i++) {
            array.add(jsonArray.get(i));
        }
        return array;
    }
}