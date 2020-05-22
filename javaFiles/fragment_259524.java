ColumnFamilyDefinition cfDef = HFactory.createColumnFamilyDefinition(keyspaceName, "UserCounters");
cfDef.setKeyValidationClass(ComparatorType.UTF8TYPE.getClassName());
cfDef.setComparatorType(ComparatorType.UTF8TYPE);
cfDef.setDefaultValidationClass(ComparatorType.COUNTERTYPE.getClassName());
cfDef.setColumnType(ColumnType.STANDARD);
cfDef.setKeyspaceName(keyspaceName);