Page pdfPage = submitInput.click();
WebResponse resp = pdfPage.getWebResponse();
if("application/pdf".equals(resp.getContentType())) {
    .... process the bytes
    .... resp.getContentAsStream()
}