public DecoratedKey buildCompositePartitionKey(CFMetaData metadata, Object... partitionKey) {
    return metadata.decorateKey(
            CFMetaData.serializePartitionKey(
                    metadata.getKeyValidatorAsClusteringComparator().make(partitionKey)
            )
    );
}