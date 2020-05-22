public static  ArrayList<String> readExcelData(int colNo) throws IOException {
            FileInputStream fis= new FileInputStream("C:\\dat.xls");
            HSSFWorkbook wb=new HSSFWorkbook(fis);
            HSSFSheet s=wb.getSheet("sh1");
            Iterator<Row> rowIterator=s.iterator();
            rowIterator.next();
            ArrayList<String> list=new ArrayList<String>();
            DataFormatter formatter = new DataFormatter();

            while (rowIterator.hasNext()) {
                 String val = formatter.formatCellValue(rowIterator.next().getCell(colNo));
                list.add(val);
            }
            System.out.println("List :::"+list);
            return list;
        }