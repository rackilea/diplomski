col.setLabelProvider(new ColumnLabelProvider() {   // Column 1 (contains the keys)
        @Override
        public String getText(Object element) {
            String str = element.toString();
            String[] parts = str.split("=");
            return parts[0];
        }
    });

col.setLabelProvider(new ColumnLabelProvider() {  // Column 2 (Contains the values)
        @Override
        public String getText(Object element) {
            String str = element.toString();
            String[] parts = str.split("=");
            return parts[1];
        }
    });