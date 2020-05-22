//app side 
PictureInputBo pictureInputBo = new PictureInputBo([your binary]); //encodes it to base64

//This is working Java code and can be used.
//It will automatically convert to JSON and sent to the "convert" endpoint of the server
ResteasyClient client = new ResteasyClientBuilder().build();
ResteasyWebTarget target = client.target("http://yourserver:8080/your-webservice/rest/convert/");
Response response = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(pictureInputBo, "application/json;charset=UTF-8;version=1"));


//Server side..."Converter Endpoint", this is also working Java code.
//it will automatically converted back to the Java object "PictureInputBo" by RestEasy
@POST
@Path("/convert")
@Consumes(MediaType.APPLICATION_JSON)
public Response convertPicture(@NotNull(message = "Must not be null") @Valid PictureInputBo inputBo)
{
    //Here you pass your business object to the converter service which processes the data
    //(pass it to python or whatever) 
    PictureOutputBo result = converterService.convert(inputBo);

    //Resteasy converts it back to JSON and responds it to the app.
    return Response.ok().entity(result).build();
}


//Back in your app.
check if response.getStatus() == 200) //HTTP Status OK
PictureOutputBo pictureOutputBo = response.readEntity(PictureOutputBo.class);