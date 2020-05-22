/**
* Returns all columns in the table (for use by the select by primary key
* and select by example with BLOBs methods)
*
* @return a List of ColumnDefinition objects for all columns in the table
*/
    public List<IntrospectedColumn> getAllColumns() {
        List<IntrospectedColumn> answer = new ArrayList<IntrospectedColumn>();
        answer.addAll(primaryKeyColumns);
        answer.addAll(baseColumns);
        answer.addAll(blobColumns);

        return answer;
    }