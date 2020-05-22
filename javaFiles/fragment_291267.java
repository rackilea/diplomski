@Test
public void testCreateColorScaleFormatting() throws IOException {
    Workbook wb1 = _testDataProvider.createWorkbook();
    Sheet sheet = wb1.createSheet();

    SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
    ConditionalFormattingRule rule1 = 
            sheetCF.createConditionalFormattingColorScaleRule();
    ColorScaleFormatting clrFmt = rule1.getColorScaleFormatting();

    assertEquals(3, clrFmt.getNumControlPoints());
    assertEquals(3, clrFmt.getColors().length);
    assertEquals(3, clrFmt.getThresholds().length);

    clrFmt.getThresholds()[0].setRangeType(RangeType.MIN);
    clrFmt.getThresholds()[1].setRangeType(RangeType.NUMBER);
    clrFmt.getThresholds()[1].setValue(10d);
    clrFmt.getThresholds()[2].setRangeType(RangeType.MAX);

    CellRangeAddress [] regions = { CellRangeAddress.valueOf("A1:A5") };
    sheetCF.addConditionalFormatting(regions, rule1);