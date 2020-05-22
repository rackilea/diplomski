Database db = new Database(); 
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {     
     List<ProductForm> prodList = db.getProduct();     
     request.setAttribute("prodList", prodList);
     return mapping.findForward("success"); 
}