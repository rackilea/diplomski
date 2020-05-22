private static final Set<Class<?>> validClasses = new HashSet<Class<?>> ();

static {
    Collections.addAll(validClasses, ShapedRecipes.class,
                                     ShapelessRecipes.class
                                     ShapedOreRecipe.class); //etc.
}