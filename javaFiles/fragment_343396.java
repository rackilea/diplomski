import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
class MyService {

@RequestMapping(value = "/abc", method = RequestMethod.POST,produces = "application/json" )
    public @ResponseBody String myMethod( @RequestBody String _json,HttpServletRequest request,
        HttpServletResponse response) {
        return _json;
    }   
}