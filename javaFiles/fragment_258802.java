@POST
@Path("/analyze")
public Session startAnalysing(ImageInputData inputData) {

    List<ImageInput> images = inputData.getImages();    
    // Do any processing...
    return session;
}