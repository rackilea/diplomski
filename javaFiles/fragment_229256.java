@POST
@Consumes({"application/xml", "application/json"})
@Produces(MediaType.APPLICATION_JSON)
public String registerClaimWithPaymentNew(MyInput input){

    return input.getMandant().getCode() + " new ";
}