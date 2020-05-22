@Controller
public class TestController {

    @PostMapping
    public ModelAndView test(@Validated @ModelAttribute final PrmBcClipInsert prmBcClipInsert, final BindingResult bindingResult) {
        final ModelAndView modelAndView = new ModelAndView();
        System.out.println(prmBcClipInsert.getTags());
        modelAndView.setViewName("test");
        return modelAndView;
    }
}