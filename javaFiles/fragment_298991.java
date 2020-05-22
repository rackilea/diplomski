@Consumes({"application/json"})
@Produces({"application/json"})
@Path("uploadfileservice")
public interface UploadFileService {

@Path("/fileupload")
@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
Response uploadFile(@Multipart("file") Attachment attr)
}



@Service
public class UploadFileServiceImpl implements UploadFileService {

@Override
public Response uploadFile(Attachment attr){
String pathToUpload= "//path//.txt"
try{
  attr.transferTo(new File(pathToUpload)); //will copy the uploaded file in 
  //this destination
}
catch(Exception e){

}

}