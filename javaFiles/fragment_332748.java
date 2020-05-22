public class AddProcessAction extends Action {

    private static final String PROC_BOX_SESSION_ATTR = "addProcessAction.procBox";

    @Override
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form, 
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        final procBox = acquireProcBoxFrom(request);
        procBox.addToProcBox((ProcessForm)form);
        return mapping.findForward("success");
    }

    private ProcBox acquireProcBoxFrom(HttpServletRequest request) {
        final HttpSession httpSession = request.getSession();
        ProcBox procBox = (ProcBox)httpSession.getAttribute(PROC_BOX_SESSION_ATTR);
        if (procBox == null) {
            procBox = new ProcBox();
            httpSession.setAttribute(PROC_BOX_SESSION_ATTR, procBox);
        }
        return procBox;
    }

}