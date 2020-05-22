PDFMergerUtility mergerUtility = new PDFMergerUtility();
    try  {
        while(rs.next())    {      
            in=resultset.getBinaryStream(1);
            mergerUtility.addSource(in);

        }       
        mergerUtility.setDestinationStream(bos);
        mergerUtility.mergeDocuments();

        bos.close();

   }
   catch (Exception e) { 

   }