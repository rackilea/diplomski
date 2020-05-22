switch (columnIndex) {
    case 0:
    case 1:
    case 2: { 
       cellValue = cell.getStringCellValue();
       break; 
    }
    case 3: {
       Date cellDate = cell.getDateCellValue();
       // ...
       break;
    } 
    case 4: {
       cellValue = cell.getNumericCellValue();
       break;
    }    
}