@Put
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Device b(Device device) {
    // Do something with the POJO!!!
    return device;
}