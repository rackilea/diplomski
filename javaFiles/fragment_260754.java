// Create mapping
XContentBuilder xb = XContentFactory.jsonBuilder()
        .startObject()
        .startObject("document")
        // - document
        .startObject("properties")
        // - properties
        //
        .startObject("content")
        .field("type", "string")
        .field("term_vector", "with_positions_offsets")
        .endObject()
        //
        //
        .startObject("contentType")
        .field("type", "string")
        .endObject()
        //
        //
        .startObject("fileName")
        .field("type", "string")
        .endObject()
        //
        //
        .startObject("fileSize")
        .field("type", "long")
        .endObject()
        //
        //
        .startObject("openable")
        .field("type", "string")
        .endObject()
        //
        //
        .startObject("ownerUserId")
        .field("type", "string")
        .endObject()
        //
        //
        .startObject("privacy")
        .field("type", "string")
        .endObject()
        //
        //
        .startObject("searchable")
        .field("type", "string")
        .endObject()
        //
        // - end properties
        .endObject()
        // - end document
        .endObject()
        .endObject();

// Prepare mapping
PutMappingRequestBuilder pmrb = client.admin().indices()
        .preparePutMapping("user")
        .setType("document");

pmrb.setSource(xb);

// Create type and mapping
PutMappingResponse response = pmrb.execute().actionGet();
if (!response.isAcknowledged()) {
    LOG.info("Error while creating mapping for user document.");
} else {
    LOG.info("Mapping created for user document.");
}