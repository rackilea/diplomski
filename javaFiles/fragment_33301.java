@POST
@Path("/{id}/recomendation")
public void updateRecomendations(
        Form form,

        @PathParam("id")
        Long id
        ) {
        List<Long> foods = getFoodIdsFromForm(form);

        ...
    }

private List<Long> getFoodIdsFromForm(Form form) {
    Map parametrsMap = form.asMap();
    final List<Long> foodIds = new ArrayList<Long>();
    if (parametrsMap.get("foods[]") != null) {
        List<String> idsString = (List<String>)parametrsMap.get("foods[]");
        for (String id : idsString) {
            foodIds.add(Long.parseLong(id));
        }
    }

    return foodIds;
}