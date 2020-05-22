private List<Category> selectedCategories;

@PostConstruct
public void init() {
    selectedCategories = createAndFillItSomehow();
}