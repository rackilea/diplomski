@POST
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.TEXT_PLAIN)
public File addFile(String filePath){
    return fileService.addFile(filePath);
}