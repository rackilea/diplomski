@JsonRequestMapping(method = POST)
public String defaultSettings() {
    return "Default settings";
}

@JsonRequestMapping(value = "/override", method = PUT, produces = "text/plain")
public String overrideSome(@RequestBody String json) {
    return json;
}