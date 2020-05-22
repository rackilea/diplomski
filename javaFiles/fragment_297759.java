AccountHolder[] accountHolders = new AccountHolder[xRows];

for (int i=0;i<xRows;i++) 
{ 
    HSSFRow row = mySheet.getRow(i); 

    AccountHolder accountHolder = new AccountHolder();
    accountHolder.setId(row.getCell(0).getStringCellValue());

    //todo: the rest of the String fields of AccountHolder

    accountHolder.setAccountNumber(row.getCell(5).getNumericCellValue());
    accountHolder.setZipCode(row.getCell(6).getNumericCellValue());

    accountHolders[i] = accountHolder;
}

return accountHolders;