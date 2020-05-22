public static void printUrls(JSONArray childrens) {
    JSONObject temp = null;
    for (int i = 0; i < childrens.size(); i++) {
        // get object using index from children array
        temp = (JSONObject) childrens.get(i);

        // check if it contains any nested children array key
        // if yes then , fetch the nested children array and call this funtion
        // again to print it's content 
        if (temp.containsKey("children")) {
            printUrls((JSONArray) temp.get("children"));
        }

        // fetch and print the url , most wanted guy here
        String url = (String) temp.get("url");
        if (url != null) {

            // display the url using print 
            System.out.println(url);

            // count is a variable which will be incremented when any url found
            // and total of found urls , will be displayed at the end of parsing 
            count++;
        }
    }
}