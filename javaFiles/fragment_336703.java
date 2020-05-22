@Path("/recipe")
public class RecipeResource {
@GET
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public List<Recipe> getRecipesBrowser() {
    System.out.println("REST Service Method getRecipesBrowser called");
    System.out.println("Called URI: " + uriInfo.getAbsolutePath());
    List<Recipe> dummyData = new ArrayList<>();
    dummyData.add(new Recipe(new Long(1), "Recipe1", "Description1", null));
    dummyData.add(new Recipe(new Long(2), "Recipe2", "Description2", null));
    dummyData.add(new Recipe(new Long(3), "Recipe3", "Description3", null));
    dummyData.add(new Recipe(new Long(4), "Recipe4", "Description4", null));
    dummyData.add(new Recipe(new Long(5), "Recipe5", "Description5", null));
    dummyData.add(new Recipe(new Long(6), "Recipe6", "Description6", null));
    dummyData.add(new Recipe(new Long(7), "Recipe7", "Description7", null));
    dummyData.add(new Recipe(new Long(8), "Recipe8", "Description8", null));
    dummyData.add(new Recipe(new Long(9), "Recipe9", "Description9", null));

    return dummyData;
}