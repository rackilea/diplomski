package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import usebeans.TempService;
import validators.ValidationForm;

@SuppressWarnings("deprecation")
final public class Temp extends SimpleFormController {
    private TempService tempService = null;

    public Temp() {
        // setCommandClass(Temp.class);
        // setSuccessView("Temp");
        // setFormView("Temp");

        setCommandClass(ValidationForm.class); // Still not working.
        setCommandName("validationForm");
    }

    public void setTempService(TempService tempService) {
        this.tempService = tempService;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        ModelAndView mv = new ModelAndView();
        ValidationForm validationForm = (ValidationForm) command;
        tempService.add(validationForm);
        return mv;
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request,
            HttpServletResponse response, BindException errors)
            throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put(getCommandName(), new ValidationForm());
        ModelAndView mv = new ModelAndView("Temp", model);
        return mv;
    }
}