JSONObject obj = new JSONObject(someJsonString);

Optional<String> streetName = Optional.ofNullable(obj.optJSONObject("person"))
    .map(person -> person.optJSONObject("address"))
    .map(address -> address.optString("streetName"))
;