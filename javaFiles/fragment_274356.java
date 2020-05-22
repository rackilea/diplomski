Record record;
while(rs.next()){

     record = new record();

     String fileName  = rs.getString("FileName");
     String fileID = rs.getString("FileID");
     String loanNumnber = rs.getString("loanNumnber");
     String pageNumber = rs.getString("PageNumber");

    record.setFileName(fileName);
    record.setFileID(fileID);
    record.setLoan(loanNumnber);
    record.setPage(pageNumber);

    recordData.add(record)
}

rs.close();