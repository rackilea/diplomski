public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

    ActionForward forwardPage = mapping.findForward("success");

    // do some coding

    FirstForm firstForm = new FirstForm();
    firstForm.setX(...);
    firstForm.setY(...);
    request.setAttribute("FirstForm", firstForm);

    return forwardPage;
}