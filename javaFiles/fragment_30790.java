class MyPrimaryKeyFilter implements IColumnFilter {
        private Map<String, String> pseudoKey = null;

        MyPrimaryKeyFilter(Map<String, String> pseudoKey) {
            this.pseudoKey = pseudoKey;
        }

        public boolean accept(String tableName, Column column) {
            return column.getColumnName().equalsIgnoreCase(pseudoKey.get(tableName));
        }

    }