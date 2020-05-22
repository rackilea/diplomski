public void getImage(ExpenseTO to) {
        ExpenseTO fetchEntityById = accountService.fetchEntityById(
                ExpenseTO.class, to.getExpenseId());
        byte[] fileScanned = fetchEntityById.getUploadedScanedFile();
        if (fileScanned.length <= 20) {                     
                outPutPdfToDisplay=null;            
        } else {
            outPutPdfToDisplay = new DefaultStreamedContent(
                    new ByteArrayInputStream(fileScanned));
            }
    }