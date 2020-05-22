public class ContactAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest req, HttpServletResponse resp) throws Exception {

        DynaValidatorForm sendContactForm = (DynaValidatorForm) form;
        ActionMessages messages = new ActionMessages();

        String firstName = ((String) sendContactForm.get("firstname"));
        String lastName = ((String) sendContactForm.get("lastname"));
        String emailAddress = ((String) sendContactForm.get("emailaddress"));
        String subject = ((String) sendContactForm.get("subject"));
        String comments = ((String) sendContactForm.get("comments"));
        return mapping.findForward("sendcontacts");
    }
}