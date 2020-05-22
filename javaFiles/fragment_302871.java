public CsdlEnumType getEnumType(final FullQualifiedName enmuTypeName){
    if (CET_ROLECAT.equals(enmuTypeName)) {
        return new CsdlEnumType()
            .setName(CET_ROLECAT.getName())
            .setMembers(Arrays.asList(
                    new CsdlEnumMember().setName("LOW").setValue("0"),
                    new CsdlEnumMember().setName("MEDIUM").setValue("1")
            ))
            .setUnderlyingType(EdmPrimitiveTypeKind.Int32.getFullQualifiedName())
        ;
    }
    return null;
}