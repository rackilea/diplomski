public String getValue(String fileName, String rowNum, int colHeader)
    {
        String returnVal = null;
        String relativePath = System.getProperty("user.dir");
        String csvPath = relativePath + "\\src\\main\\resources\\CSV\\" + fileName + ".csv" ;
        CsvReader r;
        try {
            r = new CsvReader(csvPath);
            while(r.readRecord())
            {
                String row = r.get(0);
                if(row.equalsIgnoreCase(rowNum) )
                {
                    returnVal = r.get(colHeader);
                    break;
                }
            }
            r.close();
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return returnVal;

    }