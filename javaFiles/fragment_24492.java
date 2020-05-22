class IngredientFormModel{

   //It is important to use AutoPopulatingList as your list is dynamic 
   AutoPopulatingList<IngredientQuantity> ingredientQuantityList = new AutoPopulatingList<IngredientQuantity>(IngredientQuantity.class);   
}

@RequestMapping(method=RequestMethod.GET)
public String setupForm(Model model) {      
    model.addAttribute("dish", dish);

    IngredientFormModel ingredientFormModel = new IngredientFormModel();

    model.addAttribute("ingredientFormModel", ingredientFormModel)
    return "viewName";
}