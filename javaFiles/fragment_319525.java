@Controller
@RequestMapping("/orders")
public OrderController {

   @RequestMapping("/check_first_last/{code}")
   @ResponseBody
   public Result checkFirstLast(@PathVariable String code, 
        @RequestParam int first, 
        @RequestParam int last, 
        @RequestParam("order_quantity") int orderQuantity)  {

       // fetch the result
       Result result = fetchResult(...);
       return result;
  }
}