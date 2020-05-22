List<InputStream> sources = new ArrayList<InputStream>();
int pdfPageCount = 17;
try
{
    for (int p = 1; p <= pdfPageCount; ++p)
    {
        String pdfUrl = "abc.org/invoicepdf.pdf?Range=" + p;
        URL pdfDownload = new URL(pdfUrl);
        HttpsURLConnection connectionGet = (HttpsURLConnection) pdfDownload.openConnection();
        String authorizationHeader1 = "Bearer " + getToken;
        connectionGet.setRequestProperty("Authorization", authorizationHeader1);
        connectionGet.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connectionGet.setRequestMethod("GET");
        int responseCode = connectionGet.getResponseCode();
        if (responseCode != 404)
        {
            sources.add(connectionGet.getInputStream());
        }
        else
        {
            //TODO error handling
            return;
        }
    }
    PDFMergerUtility pdfMerger = new PDFMergerUtility();
    pdfMerger.addSources(sources);
    pdfMerger.setDestinationFileName("CopyOfInvoice1.pdf");
    pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
}
catch (IOException e)
{
     //TODO error handling
     return;
}
finally
{
    // cleanup
    for (InputStream source : sources)
    {
        IOUtils.closeQuietly(source);
    }   
}