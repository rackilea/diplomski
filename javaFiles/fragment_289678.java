public class WebTierService{

    ChainedValidator validator;

    public Response serviceMethod(Request request){
        try{
            //...
            validator.doChainValidate(request);
            //...
        }catch(ValidationException e){

            return Response.status(400).entity(e.getMessage()).build();
        }

    }
}