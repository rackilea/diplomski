public class ProductionAction extends DispatchAction {
        public ActionForward showProductionConent(ActionMapping mapping, ActionForm form,
                HttpServletRequest  request,HttpServletResponse response) throws STException  
        {           
            //.. get productionContent here
            request.setAttribute("productionContent",productionContent);    
            return mapping.findForward("showProductionContent");
        }   
    }