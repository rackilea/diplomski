import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
class OrderController {

    private final NewOrderFilesValidator newOrderFilesValidator;

    @Autowired
    OrderController(NewOrderFilesValidator newOrderFilesValidator) {
        this.newOrderFilesValidator = newOrderFilesValidator;
    }

    @InitBinder("newOrderFiles")
    void initOrderFilesBinder(WebDataBinder binder) {
        binder.addValidators(newOrderFilesValidator);
    }

    @ResponseStatus(NO_CONTENT)
    @RequestMapping(value = ORDERS_PATH, method = POST, consumes = MULTIPART_FORM_DATA_VALUE)
    void createOrder(
            @Valid @ModelAttribute NewOrderFilesDTO newOrderFiles
    ) {

    }
}