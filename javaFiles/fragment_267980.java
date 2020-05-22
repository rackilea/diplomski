AreaReference a=new AreaReference(new CellReference("A1"), new CellReference("E7"));
    CellReference b=new CellReference("I5");
    XSSFPivotTable pivotTable = sheet.createPivotTable(a,b);
    pivotTable.addReportFilter(0);
    pivotTable.addReportFilter(1);
    pivotTable.addRowLabel(2);

pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(2).setOutline(false);

    pivotTable.addRowLabel(3);
    pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 4, "Sum");