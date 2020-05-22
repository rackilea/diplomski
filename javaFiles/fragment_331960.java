ColumnFamilyDefinition cfDef = HFactory.createColumnFamilyDefinition("MyKeyspace", "ColumnFamilyName", ComparatorType.BYTESTYPE);

KeyspaceDefinition newKeyspace = HFactory.createKeyspaceDefinition("MyKeyspace", ThriftKsDef.DEF_STRATEGY_CLASS,  replicationFactor, Arrays.asList(cfDef));

// Add the schema to the cluster.
// "true" as the second param means that Hector will block until all nodes see the change.
cluster.addKeyspace(newKeyspace, true);