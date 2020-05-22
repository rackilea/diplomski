// Create the cell style in the new WorkBook
CreationHelper createHelper = outputWB.getCreationHelper();
CellStyle outputStyle = outputWB.createCellStyle(); 

// Set the data format using the data format string
outputStyle.setDataFormat(createHelper.createDataFormat()
        .getFormat(cell.getCellStyle().getDataFormatString()));
// Set the created cell style to the new cell
newCell.setCellStyle(outputStyle);