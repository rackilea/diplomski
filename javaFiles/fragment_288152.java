public class controller2 extends SimpleFormController implements Serializable {
        private PersonManager pManager ;   
        @Override
        public ModelAndView onSubmit (Object command) throws ServletException, IOException { 

              Person p = (Person) command;
             Map<String,Object> model = new HashMap<String,Object>();
                    pManager.UpdatePerson(p);
                    model.put("person", p);
                   return new ModelAndView("SuccesfulUpdate","model",model);

            }

        protected Object formBackingObject(HttpServletRequest request,HttpServletResponse response)
                 throws ServletException, IOException {
                            String  id = request.getParameter("ID");
                            if(id==null) {
                                response.sendRedirect("controller1.htm");
                                return null;
                            } else{
                        Personne p = pManager.getPersonbyID(id);
                              return p;
                    }}

     protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)throws Exception {
        String id = request.getParameter("ID");
    if (id==null) return new ModelAndView("redirect:controller1.htm");
    else{
            Personn p = (Personne) formBackingObject(request, response);
        return new ModelAndView("UpdatePersonForm","Person",p);
        }}