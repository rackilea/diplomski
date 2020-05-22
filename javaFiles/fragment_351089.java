@PostConstruct
public init(){
    listOfRoles = roleFacade.getListOfRoles();
    listChoosenRoles = new ArrayList();
    listOfDualRoles = new DualListModel<Roles>(listOfRoles, listChoosenRoles);
}