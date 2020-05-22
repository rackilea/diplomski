@ApplicationScoped
public class ApiRequest {

    @Inject
    @ServiceProducer
    private ResteasyWebTarget target;

    public void rest() {
        try {
            IServices service = target.proxy(IServices.class);
            ApiRequestModel api = new ApiRequestModel(11, "22", 0);
            Response response = service.putservice(api);
            ApiResponseModel apiResponse = response.readEntity(ApiResponseModel.class);
            System.out.println("API-JAVA>> " + "CNPJ: " + apiResponse.getCnpj() + " ADQ: " + apiResponse.getAdq() + " BLOCKCODE: " + apiResponse.getBlockcode());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}