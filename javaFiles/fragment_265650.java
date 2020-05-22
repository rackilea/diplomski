@EJB
private StepsFacade stepsFacade = new StepsFacade();

@EJB
private CategoriesFacade categoryFacade = new CategoriesFacade();

public ExamResults() {
    createCategoryModel();
}