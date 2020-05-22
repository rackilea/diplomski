@Controller
public final class TestController extends BaseController {

    @RequestMapping(value = "/some/url/for/downloading/files/{file}",
                    produces = "text/plain")
    @ResponseBody
    public byte[] getFile(@PathVariable final String file) throws IOException {
        return Files.toByteArray(new File("log/" + file));
    }

}