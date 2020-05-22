@EJB
private StepsFacade stepsFacade;

@EJB
private CategoriesFacade categoryFacade;

@PostConstruct
public void init() { // Note: method name is fully to your choice.
    createCategoryModel();
}