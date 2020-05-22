Object value = tableData.getModel().getValueAt(rowIndex, 4);
        int categoryID = 0;

        if(value!= null){
            if (value instanceof String && !((String)value).isEmpty()) {
                categoryID = getKeyForValue((String)value);
            } else if(value instanceof Number) {
                categoryID = (Integer) value;
            }
        }