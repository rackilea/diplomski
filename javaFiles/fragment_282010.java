@RestController
@RequestMapping(ApiVersion.V1.prefix)
public class BatchController {
    @PostMapping("/batch")
    public @ResponseBody BatchResponse runBatch(@RequestBody BatchRequest batchRequest, HttpServletRequest request) throws IOException {
        System.out.println(batchRequest.getName());
        request.setAttribute("batchRequest" , batchRequest);
        throw new IllegalArgumentException("Some error");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public @ResponseBody BatchResponse handle(HttpServletRequest request) {
        BatchRequest batchRequest = (BatchRequest) request.getAttribute("batchRequest");
        System.out.println("handling exception");
        return new BatchResponse(batchRequest.getName());
    }
}