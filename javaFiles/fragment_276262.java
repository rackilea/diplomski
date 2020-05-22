for(int taIdx = 0; taIdx < totalSize; taIdx++) {
    Form3AReportObject frObj = (Form3AReportObject)reportRows.get(taIdx);

    localfilename = companyId + "_" +  frObj.empNumber + ".pdf";

    FileInputStream local_fis = new FileInputStream(localfilename);

    pdfWriter.freeReader(new PdfReader(local_fis));

    pdfWriter.flush();
}

pdfWriter.close();