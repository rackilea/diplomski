StdTypeResolverBuilder resolver = new StdTypeResolverBuilder() {
        @Override
        public TypeSerializer buildTypeSerializer(SerializationConfig config, JavaType baseType, Collection<NamedType> subtypes) {
            if (baseType.isPrimitive()) {
                return null;
            }
            return super.buildTypeSerializer(config, baseType, subtypes);
        }

        @Override
        public TypeDeserializer buildTypeDeserializer(DeserializationConfig config, JavaType baseType, Collection<NamedType> subtypes) {
            if (baseType.isPrimitive()) {
                return null;
            }
            return super.buildTypeDeserializer(config, baseType, subtypes);
        }

    };