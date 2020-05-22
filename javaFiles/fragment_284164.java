public WritableCellFormat createFormatCellStatus(boolean b) throws WriteException{
    Colour colour = (b == true) ? Colour.GREEN : Colour.RED;
    WritableFont wfontStatus = new WritableFont(WritableFont.createFont("Arial"), WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, colour);
    WritableCellFormat fCellstatus = new WritableCellFormat(wfontStatus);

    fCellstatus.setWrap(true);
    fCellstatus.setAlignment(jxl.format.Alignment.CENTRE);
    fCellstatus.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
    fCellstatus.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.MEDIUM, jxl.format.Colour.BLUE2);
    return fCellstatus;
}