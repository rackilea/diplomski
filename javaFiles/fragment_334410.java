public class Recipe {
   private final SimpleStringProperty name = new SimpleStringProperty("");

   public Recipe() {
        this("");
    }

    public Recipe(String recipeName) {
        setRecipeName(recipeName);

    }

    public String getRecipeName() {
        return name.get();
    }

    public void setRecipeName(String rName) {
        name.set(rName);
    }

    public StringProperty recipeNameProperty() {
        return name ;
    }

}