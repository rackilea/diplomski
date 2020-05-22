@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(BigDecimal.class, new BigDecimalEditor());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(
            @RequestParam("amount") @NumberFormat(pattern = "#.###,##") BigDecimal amount) {
        System.out.println(amount);
        return new ModelAndView();
    }
}