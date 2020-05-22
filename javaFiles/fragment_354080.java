@GET
@Path("/locations/{id}")
@Produces(value = {"application/vnd.mycompany-v2+json", // current version
                   "application/vnd.mycompany-v1+json", // old version
                   MediaType.APPLICATION_JSON})         // fallback
public Response getLocation(@PathParam("id") Integer id,
                            @Context Request request) {
    MediaType vndTypeV1 = new MediaType("application", "vnd.mycompany-v1+json");
    MediaType vndTypeV2 = new MediaType("application", "vnd.mycompany-v2+json");
    Variant variant1 = new Variant(vndTypeV1, null, null);
    Variant variant2 = new Variant(vndTypeV2, null, null);
    Variant variantJson = new Variant(MediaType.APPLICATION_JSON_TYPE, null, null);
    List<Variant> variants = new ArrayList<Variant>();
    variants.add(variant1);
    variants.add(variant2);
    variants.add(variantJson);

    Variant selectedVariant = request.selectVariant(variants);

    Location location = someBackendService.getLocation(id);

    // Manipulate location according to which variant is the selectedVariant.
    // ...

    return Response.ok("{}")
        .header(HttpHeaders.CONTENT_TYPE, selectedVariant.getMediaType())
        .build();
}