public class GenericAction implements ControllerAction {
  private Form form;
  private String page;

  GenericAction(Form form, String page) {
    this.form = form;
    this.page = page;
  }

  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    Item item = form.performDelete(request);

    RequestDispatcher view = request.getRequestDispatcher(page);
    view.forward(request, response);
  }
}

...
CommitmentListDAO clDAO = new CommitmentListDAO();
CommitmentItemForm ciForm = new CommitmentItemForm(clDAO);
GenericAction deleteCommitmentAction = new GenericAction(ciForm, "views/commitmentView_v.jsp");

ProgramDAO prgDAO = new ProgramDAO();
ProgramForm prgForm = new ProgramForm(prgDAO); 
GenericAction deleteProgramAction = new GenericAction(prgForm, "views/programView_v.jsp");