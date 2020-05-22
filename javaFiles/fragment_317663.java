public class RecipeListModelImpTest {

        @Mock RecipesAPI recipesAPI;
        @Mock RecipeListModelContract.RecipeGetAllListener recipeGetAllListener;

        @Inject SchedulerProvider schedulerProvider;

        private RecipeListModelContract recipeListModel;

        @Before
        public void setup() {
            TestComponent component = DaggerTestComponent.builder()
                                                         .myModule(new TestModule())
                                                         .build();
            component.inject(this);

            MockitoAnnotations.initMocks(this);
            recipeListModel = new RecipeListModelImp(recipesAPI, schedulerProvider);
        }
        ...
    }