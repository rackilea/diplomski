@Controller
public class MyController {

    @RequestMapping("/")
    public String showForm(final Model model) {
        final Receipt receipt = new Receipt();
        final Random rand = new Random();
        final int feedbackCount = rand.nextInt(20) + 1;

        for (int i = 0; i < feedbackCount; i++) {
            final Feedback feedback = new Feedback();

            feedback.setSatisfaction(rand.nextBoolean() ? SATISFIED : NOT_SATISFIED);
            feedback.setComment("Some comment.");
            receipt.getFeedbacks().add(feedback);
        }

        model.addAttribute("receipt", receipt);

        return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String printSubmittedData(final @ModelAttribute Receipt receipt) {
        System.out.println(receipt);

        return "redirect:/";
    }

}