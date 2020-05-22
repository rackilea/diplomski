String version = extractVersionFromVariant(selectedVariant);
if ("v1".equals(version)) {
    location.setSomeV1Propery("only in v1);
} else if ("v2".equals(version)) {
    location.setSomeV2Propery("only in v2);
}
return Response.ok(location)
               .header(HttpHeaders.CONTENT_TYPE, selectVariant.getMediaType())
               .build();