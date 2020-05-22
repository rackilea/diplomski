@Controller
    public class CommentController {

        @RequestMapping(value = "/api/comment", method = RequestMethod.POST)
        @ResponseBody
        public Comment add(@Valid @RequestBody Comment comment) {
            return comment;
        }
    }