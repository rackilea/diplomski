@Controller
public class FormController {

  @RequestMapping(value = "/validate1", method = RequestMethod.POST)
  public String updateGroup1(@Validated(Form.Group1.class) Form form, Errors errors) {
    if (errors.hasErrors()) {
      // return to the same view
    }
    // return success
  }

}