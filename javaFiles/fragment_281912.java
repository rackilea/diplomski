@RequestMapping("/spinner")
public class SpinnerController {

@RequestMapping(method = RequestMethod.GET,
                produces = "application/json")
public @ResponseBody String spinner() throws InterruptedException {
    Thread.sleep(10);
    return "[{\"answer\":1}]";
}
}