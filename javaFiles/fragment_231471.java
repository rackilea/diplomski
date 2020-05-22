@FeignClient("input-format")
public interface InputFormatClient {

    @GetMapping("/")
    boolean checkFormat(String input);

}