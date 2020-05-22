if (r.rated instanced Boolean) {
    // handle that
} else {
    ActualRated actual = mapper.convertValue(r.rated, ActualRated.class);
}
// or, if you used JsonNode, use "mapper.treeToValue(ActualRated.class)