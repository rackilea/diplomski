@Path("{categoryId}/products")
public CategoryProductResource getCategoryProducts(
             @PathParam("categoryId") int id,
             @Context ResourceContext rc) {
    return rc.initResource(new CategoryProductResource(id));
}