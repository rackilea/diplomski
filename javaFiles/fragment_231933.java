import org.glassfish.jersey.media.multipart.FormDataMultiPart;

FormDataMultiPart fdm=new FormDataMultiPart();
fdm.field("abc", Object o1, MediaType.APPLICATION_yourmediatype).field("cba", 
Object o2, MediaType.APPLICATION_yourmediatype);
Response response=Response.ok(fdm, MediaType.MULTIPART_FORM_DATA).build();