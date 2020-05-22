@RequestMapping(value = "/", params = "url", method = RequestMethod.GET)
public String getMovie(@RequestParam String url, ...) {
    ...
}

@RequestMapping(value = "/", method = RequestMethod.GET)
public String getDefaultMovie(...) {
    ...
}