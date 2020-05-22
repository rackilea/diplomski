else if(flag==1) {
    Iterator it=l.iterator();
    while(it.hasNext())
    {
        row=sheet.createRow(rowcount);
        row.setHeightInPoints(13);
        rowcount++;
        for(int count=0;count<headcount;count++)
        {
            cell = row.createCell(count);
            cell.setCellValue(""+it.next());
        }
    }
}