@Controller
public class QuestionController {

    @Autowired
    QuestionDisplayService questionDisplayService;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    ...

    long questionid = questionService.addQuestionService(question, tagsid);