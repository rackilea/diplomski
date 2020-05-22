@POST
@Path("/setProfileImage")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.TEXT_HTML)
public String setProfileImage(
    final MimeMultipart file,
    @QueryParam("myemail") String myemail) throws IOException, javax.mail.MessagingException {

    String uploadedFileLocationOrig = httpRequest.getSession().getServletContext().getRealPath("")  + "/images/" + myemail + "_orig.png";

    FileUtils.copyInputStreamToFile(file.getBodyPart(0).getInputStream(), new File(uploadedFileLocationOrig));

    return "true";
}