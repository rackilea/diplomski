@RequestMapping(params = "action=save")
public void saveFeedback(ActionRequest request, ActionResponse response,
    @RequestParam("index") int index,
    @ModelAttribute("feedbackForm") FeedbackForm feedbackForm, Model model)
    throws PortletException {

    Feedback feedback = feedbackForm.getFeedbacks().get(index);

    logger.debug("Submitted feedback is {}", feedback);
}