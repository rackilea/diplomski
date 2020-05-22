public ActionForward myMethod(ActionMapping actionMapping,
                ActionForm myForm, HttpServletRequest httpServletRequest,
                HttpServletResponse httpServletResponse) throws Exception {
                List<Boutique> myList = new ArrrayList<Boutique>();
                form.setMyList(myList);
                            return mapping.findForward("success");

}