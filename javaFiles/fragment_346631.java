final class BaseVehicleJsonDeserializer
        extends JsonDeserializer<BaseVehicle> {

    @Override
    public BaseVehicle deserialize(final JsonParser parser, final DeserializationContext context)
            throws IOException {
        final TreeNode treeNode = parser.readValueAsTree();
        final Class<? extends BaseVehicle> baseVehicleClass = Stream.of(treeNode)
                // Check if the tree node is ObjectNode
                .filter(tn -> tn instanceof ObjectNode)
                // And cast
                .map(tn -> (ObjectNode) tn)
                // Now "bind" the object node with if the object node can be supported by the resolver
                .flatMap(objectNode -> Stream.of(BaseVehicleTypeResolver.cachedBaseVehicleTypeResolvers).filter(resolver -> resolver.matches(objectNode)))
                // If found, just get the detected vehicle class
                .map(BaseVehicleTypeResolver::getBaseVehicleClass)
                // Take the first resolver only
                .findFirst()
                // Or throw a JSON parsing exception
                .orElseThrow(() -> new JsonParseException(parser, "Cannot parse: " + treeNode));
        // Convert the JSON tree to the resolved class instance
        final ObjectMapper objectMapper = (ObjectMapper) parser.getCodec();
        return objectMapper.treeToValue(treeNode, baseVehicleClass);
    }

    // Known strategies here
    private enum BaseVehicleTypeResolver {

        CAR_RESOLVER {
            @Override
            protected Class<? extends BaseVehicle> getBaseVehicleClass() {
                return Car.class;
            }

            @Override
            protected boolean matches(final ObjectNode objectNode) {
                return !objectNode.has("numCylinders");
            }
        },

        MOTORCYCLE_RESOLVER {
            @Override
            protected Class<? extends BaseVehicle> getBaseVehicleClass() {
                return Motorcycle.class;
            }

            @Override
            protected boolean matches(final ObjectNode objectNode) {
                return objectNode.has("numCylinders");
            }
        };

        // Enum.values() returns array clones every time it's invoked
        private static final BaseVehicleTypeResolver[] cachedBaseVehicleTypeResolvers = BaseVehicleTypeResolver.values();

        protected abstract Class<? extends BaseVehicle> getBaseVehicleClass();

        protected abstract boolean matches(ObjectNode objectNode);

    }

}