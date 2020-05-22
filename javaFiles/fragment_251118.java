if (DateUtil.isCellDateFormatted(currentCell))
{
   try {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    cellValue =  = sdf.format(currentCell.getDateCellValue());

    } catch (ParseException e) {
            e.printStackTrace();
    }
}