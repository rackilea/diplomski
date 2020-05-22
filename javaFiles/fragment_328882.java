public String importCSV(@RequestParam("file") MultipartFile file,
            HttpServletRequest req) throws IOException {
        CsvToBean csv = new CsvToBean();
        CSVReader reader = new CSVReader(new InputStreamReader(
                file.getInputStream()), ',', '\"', 1);
        ColumnPositionMappingStrategy maping = new ColumnPositionMappingStrategy();
        maping.setType(tbBank.class);
        String[] column = { "bankid", "bankname", "bankbranch" };
        maping.setColumnMapping(column);
        List banklist = csv.parse(maping, reader);
        for (Object obj : banklist) {
            tbBank bank = (tbBank) obj;
            projectservice.insertBank(bank);
        }
        return "redirect:/bankview";
    }