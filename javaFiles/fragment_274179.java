@SuppressWarnings("unchecked")
private void removeRecipes(String toDelete)
{    
    ItemStack resultItem = new ItemStack((Item)Item.itemRegistry.getObject(toDelete));
    resultItem.stackSize = 1;
    resultItem.setItemDamage(0);

    List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

    for (int i = 0; i < recipes.size(); i++)
    {
        IRecipe tmpRecipe = recipes.get(i);

        ItemStack recipeResult = tmpRecipe.getRecipeOutput();
        if(recipeResult != null) 
        {
            recipeResult.stackSize = 1;
            recipeResult.setItemDamage(0);
        }

        if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
        {
            recipes.remove(i--);
        }
    }
}