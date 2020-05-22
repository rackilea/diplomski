for(int i=1; i11; i++){
    String srnum = String.valueOf(rnum);
    wsheet.addCell(new jxl.write.Label(1, rc, srnum, createFormatCellStatus(true)));    //will create green cell
    wsheet.addCell(new jxl.write.Label(2, rc, "b", createFormatCellStatus(false))); //will create red cell
    wsheet.addCell(new jxl.write.Label(3, rc, "c", createFormatCellStatus(false)));
    wsheet.addCell(new jxl.write.Label(4, rc, "d", createFormatCellStatus(true)));
    wsheet.addCell(new jxl.write.Label(5, rc, "e", createFormatCellStatus(false)));
    wsheet.addCell(new jxl.write.Label(6, rc, "f", createFormatCellStatus(true)));  

    rnum++;
    rc++;   
    System.out.println(""+rnum+"\n"+rc);
}
wbook.write();
wbook.close();