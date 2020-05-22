@RestController
@RequestMapping("/")
public static class Ctrl {
    private final ObjectMapper mapper = new ObjectMapper();

    @PostMapping
    public String post(@RequestBody String body) throws IOException {
        final JsonNode jsonNode = mapper.readTree(body);
        return "UserId is: " + jsonNode.findValue("userId");
    }
}