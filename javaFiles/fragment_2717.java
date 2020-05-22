class EmployeeDAOImpl implements IEmployeeDAO {

    private final DAOFactory factory;
    private final IDepartmentDAO departmentDAO;

    public EmployeeDAOImpl(DAOFactory factory, IDepartmentDAO departmentDAO) {
        this.factory = factory;
        this.departmentDAO = departmentDAO;
    }
    ...