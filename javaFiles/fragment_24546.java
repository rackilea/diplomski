@GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
@ResponseBody // <== added annotation
public Employee html() {
    return Employee.builder()
        .name("test")
        .build();
}