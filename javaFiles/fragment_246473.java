@Controller
public class CandidateController {

   @ModelAttribute("Candidate")
   public Candidate getCandidate() {
      return new Candidate();
   }

}