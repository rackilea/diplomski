public class ReadExcelUtil {

    public static HashMap<String, List<String>> readData(MultipartFile file) {

        HashMap<String, List<String>> result = new HashMap<>();
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Workbook workbook = null;
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        switch (extension.toLowerCase()) {
            case "xls": {
                try {
                    workbook = new HSSFWorkbook(inputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case "xlsx": {
                try {
                    workbook = new XSSFWorkbook(inputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            default:
                throw new RuntimeException("Unsupported file extension. Valid are XLS and XLSX.");
        }

        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
            final int cellIndex = i;
            final List<String> value = new ArrayList<>();
            final String[] key = {""};
            sheet.forEach((Row row) -> {
                row.forEach((Cell cell) -> {
                    final int rowIndex = row.getRowNum();
                    if (cellIndex == cell.getColumnIndex()) {
                        if (rowIndex == 0) {
                            key[0] = getCellValue(cell);
                        } else {
                            value.add(getCellValue(cell));
                        }
                    }
                });
                result.put(key[0], value);
            });
        }
        return result;
    }

    protected static String getCellValue(Cell cell) {

        String result = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    result = String.valueOf(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    result = String.valueOf(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    result = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                case Cell.CELL_TYPE_ERROR:
                    break;
            }
        }
        return result;
    }
}