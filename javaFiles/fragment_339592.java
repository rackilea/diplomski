@Controller
public class ExampleController {

    private Timesheet timesheet;

    public ExampleController() {
        List<Task> tasks = new ArrayList<Task>();
        tasks.add(new Task(1, "Hello", 0, 0, 0, 0, 0, 0, 0));
        tasks.add(new Task(2, "Bai", 0, 0, 0, 0, 0, 0, 0));
        tasks.add(new Task(3, "I'm back", 0, 0, 0, 0, 0, 0, 0));
        this.timesheet = new Timesheet(tasks);
    }

    @RequestMapping(value = "/timesheet.do", method = RequestMethod.GET)
    public ModelAndView displayTimeSheet() {
        return new ModelAndView("timesheet", "timesheet", timesheet);
    }

    @RequestMapping(value = "/timesheet.do", method = RequestMethod.POST)
    public ModelAndView updateTimeSheet(@ModelAttribute("timesheet") Timesheet timesheet) {
        this.timesheet = timesheet;
        return new ModelAndView("timesheet", "timesheet", timesheet);
    }

}