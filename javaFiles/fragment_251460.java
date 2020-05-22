ServletOutputStream servletOutPutStream = response.getOutputStream();;
[...]
for(byte[] imageList:imageMap)
{
     [...]
     byteArrayOutputStream.writeTo(response.getOutputStream());
     [...]
}
[...]
PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
[... merge PDFs into the writer]

servletOutPutStream.flush();
document.close();

servletOutPutStream.close();