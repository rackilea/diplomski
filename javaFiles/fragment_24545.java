@GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
@ResponseBody // <== added annotation
public String html() { // <== changed return type (HTML is text, i.e. a String)
    return Employee.builder()
        .name("test")
        .build()
        .toHtml(); // <== added call to build HTML content
}