// Creating an XLS LoadOptions object
LoadOptions loadOptions = new LoadOptions(FileFormatType.EXCEL_97_TO_2003);

// Setting the password for the encrypted Excel file
loadOptions.setPassword("1234");

    //Instantiate a Workbook object
    Workbook workbook = new Workbook("C:\\book1.xls", loadOptions);

    //Retrieve a list of all custom document properties of the Excel file
    CustomDocumentPropertyCollection customProperties = workbook.getWorksheets().getCustomDocumentProperties();

    //Accessng a custom document property by using the property name
    DocumentProperty customProperty2 = customProperties.get("myName");