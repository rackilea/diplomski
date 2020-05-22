@Produces(MediaType.APPLICATION_JSON)
    public String addEntity(@FormParam("entity") String jsonEntity, @FormParam("entityType") String jsonEntityType) {
        JsonObject jSonStatus = null;
        ....
        ....    
        return JsonStatus.toString;
}