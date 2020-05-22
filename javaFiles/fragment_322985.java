@Controller

public class AddExamController {

@Autowired
private ExamRepository examRepository;
@Autowired
private SubjectRepository subjectRepository;
@Autowired 
private UserRepository userRepository;

@ModelAttribute("exam")
public Exam exam() {
    return new Exam();
}


@GetMapping("/addexam")
public String showExamForm(Model model) {

    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    String email = loggedInUser.getName();   

    User user = userRepository.findByEmailAddress(email);

    ArrayList<String> subjects = new ArrayList<String>();

    for(Subject sub:user.getSubject())
    {
        subjects.add(sub.getSubjectName());
    }
    model.addAttribute("subjects", subjects);

return "addExam";
}

@PostMapping("/addExam") //This was causing one problem i was getting. I had it as /addexam and it should have been addExam
public String addNewExam(@ModelAttribute("exam") @Valid @RequestBody Exam exam,UserRegistrationDto userDto, BindingResult result, Model model) {

    examRepository.save(exam);
    model.addAttribute("examTitle", exam.getExamTitle());
    model.addAttribute("examGradeWorth", exam.getExamGradeWorth());
    model.addAttribute("subject", "");



    //String subjectName = ("subject", exam.getSubject());

//  Subject subject = subjectRepository.findBySubjectName(subjectName);
    //subject.addExam(exam);
/// subjectRepository.save(subject);

return "userProfile1";


    }
}