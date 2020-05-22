file = new File(device_records.xlsx);
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition", "attachment; filename=device_records.xlsx");
    out = new FileOutputStream(file);
    workbook.write(out);
    workbook.write(response.getOutputStream());