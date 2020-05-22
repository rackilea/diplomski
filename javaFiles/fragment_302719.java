@Provider
public class CrossDomainFilter implements ContainerResponseFilter {

@Override
public ContainerResponse filter(ContainerRequest req,ContainerResponse contResp) {
    // TODO Auto-generated method stub

    ResponseBuilder resp = Response.fromResponse(contResp.getResponse());
    resp.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, OPTIONS");

    String reqHead = req.getHeaderValue("Access-Control-Request-Headers");

    if (null != reqHead && !reqHead.equals("")) {
        resp.header("Access-Control-Allow-Headers", reqHead);
    }

    contResp.setResponse(resp.build());
    return contResp;
}
}