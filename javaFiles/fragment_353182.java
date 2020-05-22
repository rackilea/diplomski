@POST
@Path("/{contestType}/pay")
@Consumes(MediaType.APPLICATION_JSON)
public Response pay(@PathParam("contestType") String contestType,
                    PaymentDetails paymentDetails) {
    ...
}