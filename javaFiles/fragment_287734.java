@Controller
@RequestMapping(value = "/foo")
public class FooAdminController {

    @RequestMapping(value = "/bar")
    public ModelAndView bar(ModelAndView mav) {

        mav.setViewName("bar");
        return mav;
    }
}