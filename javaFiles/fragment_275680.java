public class CompanyAction extends ActionSupport implements Preparable {

private List<Company> listAllCompanys;

//Getters and setters...

public List<Company> getListAllCompanys() {
  return listAllCompanys;
}

@Override
public void prepare() throws Exception {
    CompanyDaoHibernate dao = new CompanyDaoHibernate();
    listAllCompanys = dao.getListOfCompanies();
    System.out.println("Populated listAllCompanys from " +getClass().getSimpleName()+ " size: " +listAllCompanys.size());

}

public String listAllCompanys() throws Exception {
    System.out.println("The action " + ActionContext.getContext().getName()+ " is called");
    return SUCCESS;
}