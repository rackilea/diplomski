@Controller
@RequestMapping("/admin/alias")
public class AliasesController {

@RequestMapping(value = "{id}", method = RequestMethod.GET)
public @ResponseBody SampleAliasMaskModel index(@PathVariable("id") Integer id) {