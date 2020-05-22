@POST
@Path("getReceipt")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ "application/pdf" })
public byte[] getReceipt(InputStream incomingData) {
     return your_pdf_byte_array;
}