@POST
// @Consumes(MediaType.APPLICATION_JSON)
// @Produces(MediaType.APPLICATION_JSON)
public String getFilteredPictures(String jsonFilters)
{
    PictureProvider provider = new PictureProvider();
    ArrayList<PictureInfo> pictures = null;
    ArrayList<FilterOption> filters = null;
    if (jsonFilters != null)
    {
        Type collectionType = new TypeToken<ArrayList<FilterOption>>()
        {}.getType();
        filters = gson.fromJson(jsonFilters, collectionType);
    }
    .....