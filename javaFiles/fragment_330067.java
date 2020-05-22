public TableCellRenderer getCellRenderer(int row, int col){
            //Only care about the first column
            if(col == 1){
                Row obj = ((CustomModel)(table.getModel())).getRow(row);
                //Check to see if this is a color
                if(obj.getType() == ObjectProperties.TYPE.COLOUR){
                    return super.getDefaultRenderer(Color.class);
                }
            }
            //Either this wasn't a color or it wasn't the first column, either way its super.getCellRenderer's problem now
            return super.getCellRenderer(row, col);
        }