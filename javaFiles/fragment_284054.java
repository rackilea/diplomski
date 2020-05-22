public class PrintPDF extends AbstractAction {

    @Override
    public Event doExecute(RequestContext context) {

        Result obj = (Result)context.getFlowExecutionContext().getConversationScope().get("result");
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getNativeRequest();
        req.getSession().setAttribute("result", obj);
        return success();
    }

}