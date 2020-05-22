// can resolve dependencies by itself
 Presenter presenter = new Presenter();

 // Dependency injection hard at work within your constructor
 @Inject
 Presenter(Model model, View view) {
      this.model = model;
      this.view = view;
 }