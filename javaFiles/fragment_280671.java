InputStream ifp = mgr.open("detail_schema.json");
JsonNode root = mapper.readTree(ifp);
JsonNode fields = root.get("fields");
for (JsonNode children : fields.getElements()) {
    // ...
}