@Async
@RequestMapping("{name}/**")
@ResponseBody
public CompletableFuture<Void> incomingRequest(
        @PathVariable("name") String name,
        HttpMethod method,
        HttpServletRequest request,
        HttpServletResponse response)
{
    String URI = request.getRequestURI(); // should get the right non null path
    return CompletableFuture.completedFuture(null);
}