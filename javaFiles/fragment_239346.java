@RequestMapping(
    value = "/orders/{id}",
    method = RequestMethod.GET,
    produces = "application/vnd.example-v1")
@ResponseBody
public Order getOrderV1(@PathVariable("id") Long id) {
    return getOrder(id);
}

@RequestMapping(
    value = "/orders/{id}",
    method = RequestMethod.GET,
    produces = "application/vnd.example-v2")
@ResponseBody
public Order getOrderV2(@PathVariable("id") Long id) {
    return getOrder(id);
}

private Order getOrder(Long id) {
    return orderRepo.findOne(id);
}