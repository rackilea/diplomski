public class StudentSearchController {

     @Autowired
     StudentService studentService;


     // added this assuming that you need courses from database
     @Autowired
     CourseService courseService;
     StudentModel studentmodel;

      @RequestMapping(method = RequestMethod.GET)
      public ModelAndView init() {
               studentmodel = new StudentModel();
               ModelAndView modelAndView = new ModelAndView();
               //assuming that your seach page is named studentpage
               List<Course> courses  = courseService.findCourses(..);
               modelAndView.addObject("student", studentmodel );  
               modelAndView.addObject("courses", courses);  
               //OR
               modelAndView.addObject("enrolments",courseService.findTheCourseYouNeed(..));
               // any other logic
       return modelAndView;
       }

      @RequestMapping(value = "/sisStudentSearch", method = RequestMethod.POST)
     public ModelAndView searchStudents(@ModelAttribute("student") StudentModel student,
                    Map<String, Object> map, HttpServletRequest request) {
                //here you can acess your courseNumber from StudentModel student
               // Apply you logic by calling the studentService filter method that gets attributs from the model
                ModelAndView modelAndView = new ModelAndView("sisStudent");
                modelAndView.addObject("students", students);
                return modelAndView;

     }   
}