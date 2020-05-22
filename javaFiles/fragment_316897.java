public static class SqlFunctionsMetadataBuilderContributor
        implements MetadataBuilderContributor {

    @Override
    public void contribute(MetadataBuilder metadataBuilder) {
        metadataBuilder.applySqlFunction(
                "date_trunc",
                new SQLFunctionTemplate(
                        StandardBasicTypes.TIMESTAMP,
                        "date_trunc('day', (?1 AT TIME ZONE ?2))"
                )
        );
    }
}