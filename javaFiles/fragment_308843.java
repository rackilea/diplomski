MutableList<Ingredient> ingredients =
        Lists.mutable.with(
                new Ingredient("Flour"),
                new Ingredient("Sugar"),
                new Ingredient("Eggs"),
                new Ingredient("Milk"));
String delimitedNames =
        ingredients.collect(Ingredient::getName).makeString(", ");
Assert.assertEquals("Flour, Sugar, Eggs, Milk", delimitedNames);