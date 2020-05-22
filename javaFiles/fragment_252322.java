public class ApiEntryFactory implements Serializable {

    private static final long serialVersionUID = -1L;

    @Produces
    @ApiEntry
    public ApiEntryPoint getApiEntryPoint(ApiEntryPoint apiEntryPoint) {
        return apiEntryPoint;
    }
}