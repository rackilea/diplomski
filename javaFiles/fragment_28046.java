import javax.validation.Valid;

import name.hines.steven.medical_claims_tracker.domain.Benefit;
import name.hines.steven.medical_claims_tracker.domain.Policy;
import name.hines.steven.medical_claims_tracker.services.DomainEntityService;
import name.hines.steven.medical_claims_tracker.services.PolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/policies")
public class PolicyController extends DomainEntityController<Policy> {

    @Autowired
    private PolicyService service;

    @RequestMapping(value = "persist", method = RequestMethod.POST)
    public String createOrUpdate(@Valid @ModelAttribute("policy") Policy policy, BindingResult result) {
        if (result.hasErrors()) {
            return "createOrUpdatePolicyForm";
        }
        service.save(policy);
        return "redirect:list";
    }
}