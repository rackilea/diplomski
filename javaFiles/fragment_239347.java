// The baseline
public abstract class BaseOrderController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Order getOrder(@PathVariable("id") Long id) { ... }
}    

// V1 controller
@RequestMapping(value = "/orders", produces = "application/vnd.example-v1")
public class OrderControllerV1 extends BaseOrderController {

    ... no difference from baseline, so nothing to implement ...
}

// V2 controller
@RequestMapping(value = "/orders", produces = "application/vnd.example-v2")
public class OrderControllerV2 extends BaseOrderController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Override
    public Order getOrder(@PathVariable("id") Long id) {
        return orderRepoV2.findOne(id);
    }
}