import com.jayway.jsonpath.JsonPath;
    public static void main(String[] args) {
        // deep-search for "score" key in all the json doc
        String searchAllScores = "$..score";
        try (InputStream is1 = Files.newInputStream(Paths.get("c:/temp/xx1.json"));
                 InputStream is2 = Files.newInputStream(Paths.get("c:/temp/xx2.json"))) {
            List<String> keys1 = JsonPath.parse(is1).read(searchAllScores);
            List<String> keys2 = JsonPath.parse(is2).read(searchAllScores);
            System.out.println(keys1);
            System.out.println(keys2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }