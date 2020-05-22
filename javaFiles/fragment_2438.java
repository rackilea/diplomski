@Controller
@RequestMapping("/arithmetic-operations")
public class ArithemticOperationsController {
    @RequestMapping("/divide")
    public String divide(@Valid Divison division, BindingResult result) {
        if (result.hasErrors()) {
            return "DivisionInput";
        }
        BigDecimal result = division.getDividend().divide(division.getDivisor());
        division.setResult(result);
        return "DivisionInput";
    }
}