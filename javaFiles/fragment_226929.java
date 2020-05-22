@Controller
public class TestController {

  @GetMapping("/test")
  public String getTestView() {
    return "jobform";
  }

  @PostMapping(value = "/newjob")
  public void addNewJob(
      @ModelAttribute("addNewJob") final JobPostEntity myEntity) {
    System.out.println("got dto: " + myEntity);
    System.out.println("selectCategory: " + selectCategory);
  }

  @ModelAttribute(value = "addNewJob")
  public JobPostEntity newEntity() {
    return new JobPostEntity();
  }

}