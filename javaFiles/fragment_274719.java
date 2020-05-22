@Controller
public class JSONController {

    @RequestMapping(value="sendData")
        public @ResponseBody CustomResponse sendData(
            @RequestBody CustomRequest request)
    {
    return null;
    }

}