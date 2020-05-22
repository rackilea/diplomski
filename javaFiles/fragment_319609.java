class VendorsWrapper
{
    List<VendorWrapper> vendors = new ArrayList<VendorWrapper>();

    // gettors, settors for vendors if you need them
}

// in your deserialization code:
ObjectMapper mapper = new ObjectMapper();
JsonNode rootNode = mapper.readValue(jsonInput, VendorsWrapper.class);