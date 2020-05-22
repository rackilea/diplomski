@FeignClient("input-parse")
public interface InputParseClient {

    @GetMapping("/")
    Map<String, String> getParsedItems(@RequestParam("input") String input);

}