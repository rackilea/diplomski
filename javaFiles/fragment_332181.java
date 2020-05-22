$.getJSON("http://api.wunderground.com/api/54f05b23fd8fd4b0/geolookup/conditions/forecast/q/US/CO/Denver.json", null, new Function() {
    @Override
    public void invoke($ j, Object... args) {
        //if you are expecting a JSONObject, use:
        JSONObject json = (JSONObject) args[0];

        //otherwise, it would be: JSONArray json = (JSONArray) args[0];

        //Then to more easily parse the JSON, do this:
        Map<String, ?> map = $.map(json)

        //if you are using an array instead, you can use: Object[] array = $.makeArray(json);

        //Now just iterate through your map (or list) to get the data you want to parse.
    }
});