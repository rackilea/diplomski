public class RecipeListModelImp implements RecipeListModelContract {

        ...
        private SchedulersProvider schedulersProvider;

        @Inject
        public RecipeListModelImp(@NonNull RecipesAPI recipesAPI, 
                                  @NonNull SchedulersProvider schedulerProvider) {
            ...
            this.schedulersProvider = schedulersProvider;
        }

        ...
    }