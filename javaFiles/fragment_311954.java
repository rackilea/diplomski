public class NamingPolicy implements NamingStrategy, Serializable {

    @Override
    public String classToTableName(String className) {
        return StringHelper.unqualify(className).toLowerCase();
    }



    @Override
    public String propertyToColumnName(String propertyName) {
        return StringHelper.unqualify(propertyName);
    }



    public String singularize(String propertyName) {
        if (propertyName != null && propertyName.endsWith("s")) {
            propertyName = propertyName.substring(0, propertyName.length() - 1);
        }

        return propertyName;
    }



    @Override
    public String tableName(String tableName) {
        return tableName;
    }



    @Override
    public String columnName(String columnName) {
        return columnName;
    }



    @Override
    public String collectionTableName(
            String ownerEntity, String ownerEntityTable, String associatedEntity,
            String associatedEntityTable, String propertyName) {

        return classToTableName(ownerEntityTable) + "_" + 
                or(associatedEntityTable, singularize(propertyName));
    }



    @Override
    public String joinKeyColumnName(String joinedColumn, String joinedTable) {
        return columnName(joinedColumn);
    }



    @Override
    public String foreignKeyColumnName(
            String propertyName, String propertyEntityName,
            String propertyTableName, String referencedColumnName) {

        String header = propertyName != null ? propertyName : propertyTableName;
        if (header == null) {
            throw new AssertionFailure("NamingStrategy not properly filled");
        }

        return classToTableName(header) + "_" + referencedColumnName;
    }



    @Override
    public String logicalColumnName(String columnName, String propertyName) {
        return StringHelper.isNotEmpty(columnName)
                ? columnName : StringHelper.unqualify(propertyName);
    }



    @Override
    public String logicalCollectionTableName(
            String tableName, String ownerEntityTable, String associatedEntityTable, String propertyName) {


        if (tableName != null) {
            return tableName;
        } else {
            return tableName(ownerEntityTable) + "_" + (associatedEntityTable != null
                    ? associatedEntityTable
                    : singularize(propertyName));
        }
    }



    @Override
    public String logicalCollectionColumnName(
            String columnName, String propertyName, String referencedColumn) {
        return StringHelper.isNotEmpty(columnName)
                ? columnName
                : classToTableName(propertyName) + "_" + singularize(referencedColumn);
    }
}