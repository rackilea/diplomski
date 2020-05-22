@FeignClient("input-format")
public interface InputFormatClient {

    @GetMapping("/")
    boolean checkFormat(@RequestParam("input") String input);

}