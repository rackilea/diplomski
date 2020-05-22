@Entity
    public class Recipe extends BaseEntity {
        @Size(min = 3, max = 250)
        private String photo;
        @Size(min = 3, max = 250)
        private String name;
        @Size(min = 5, max = 250)
        private String description;
        @NotNull
        private Category category;
        @Range(min = 1, max = 2000)
        private Integer prepTime;
        @Range(min = 1, max = 2000)
        private Integer cookTime;

        @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name="recipe_id", nullable = false)
        private List<Ingredient> ingredients;

        @OneToMany(mappedBy = "recipe",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name="recipe_id", nullable = false)
        private List<Step> steps;

        private boolean isFavorite;

        public Recipe() {
           ingredients = new ArrayList<>();
           steps = new ArrayList<>();
        }

        public Recipe(String photo, String name, String description, Category category, Integer prepTime, Integer cookTime, boolean isFavorite) {
            this();
            this.photo = photo;
            this.name = name;
            this.description = description;
            this.category = category;
            this.prepTime = prepTime;
            this.cookTime = cookTime;
            this.isFavorite = isFavorite;
        }

        public List<Ingredient> getIngredients() {
            return Collections.unmodifiableList(ingredients);
        }

        public void addIngredient(Ingredient ingredient) {
            ingredient.setRecipe(this);
            ingredients.add(ingredient);
        }

        public List<Step> getSteps() {
            return  Collections.unmodifiableList(steps);
        }

        public void addStep(Step step) {
            step.setRecipe(this);
            steps.add(step);
        }
    }