package test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class YoController {

    @RequestMapping(value = "/bench", method = RequestMethod.GET)
    @ResponseBody
    public String welcome(Model model) {
        return "yo";
    }
}