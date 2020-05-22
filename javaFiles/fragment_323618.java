package test;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonParsingController {
    private final static Logger log = Logger.getLogger(JsonParsingController.class);

    @RequestMapping(value = "/cart.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
@ResponseBody public CartResponse handleCart(@RequestBody Cart cart) {
    if (cart != null) {
        log.debug(cart);
    }

    return new CartResponse("OK!");
}
}