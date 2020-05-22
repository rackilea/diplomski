@Controller
public class TaskController {

    ...

    @GetMapping({"/{page:tasks?}/{id}/start")
    public String start(@PathVariable String page, @PathVariable String id) {
        tasks.start(id);
        return "redirect:/" + page + ".html";
    }
}