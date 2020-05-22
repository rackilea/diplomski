@Controller
@RequestMapping("importExam")
public class ExamController {

    private final examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String getExams(ModelMap model) {
        model.addAttribute("exams", examService.getExams());
        return "exams";
    }

}