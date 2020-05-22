import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.openmrs.module.chitscore.model.AnthropometricData;
import org.openmrs.module.chitscore.model.VitalSigns;
import org.openmrs.module.chitscore.service.AnthropometricDataService;
import org.openmrs.module.chitscore.service.VitalSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ITRController {
    @Autowired
    private AnthropometricDataService anthropometricDataService;
    @Autowired
    private VitalSignsService vitalSignsService;

    AnthropometricData anthropometricData = new AnthropometricData();
    VitalSigns vitalSigns = new VitalSigns();

    @RequestMapping(value="/patient/itr")
    public String setupForm(Map<String, Object> map){
        map.put("anthropometricdata", anthropometricData);
        map.put("anthropometricdataList", anthropometricDataService.getAllAnthropometricData());
        map.put("vitalsigns", vitalSigns);
        map.put("vitalsignsList", vitalSignsService.getAllVitalSigns());
    }

    @RequestMapping(value="/patient/anthropometricdata.form", method=RequestMethod.POST)
    public String doActions(@ModelAttribute("anthropometricdata") AnthropometricData anthropometricData, BindingResult result, @RequestParam String action, Map<String, Object> map){
        AnthropometricData anthropometricDataResult = new AnthropometricData();
        switch(action.toLowerCase()){   //only in Java7 you can put String in switch
        case "save":
            Date timestamp = new Date();
            anthropometricData.setTimestamp(timestamp);
            anthropometricDataService.add(anthropometricData);
            anthropometricDataResult = anthropometricData;
            break;          
        }

        map.put("anthropometricdata", anthropometricDataResult);
        map.put("anthropometricdataList", anthropometricDataService.getAllAnthropometricData());
        map.put("vitalsigns", vitalSigns);
        map.put("vitalsignsList", vitalSignsService.getAllVitalSigns());
    }

    @RequestMapping(value="/patient/vitalsigns.form", method=RequestMethod.POST)
    public String doActions(@ModelAttribute("vitalsigns") VitalSigns vitalSigns, BindingResult result, @RequestParam String action, Map<String, Object> map){
        VitalSigns vitalSignsResult = new VitalSigns();
        switch(action.toLowerCase()){   //only in Java7 you can put String in switch
        case "save":
            Date timestamp = new Date();
            vitalSigns.setTimestamp(timestamp);
            vitalSignsService.add(vitalSigns);
            vitalSignsResult = vitalSigns;
            break;          
        }

        map.put("vitalsigns", vitalSignsResult);
        map.put("vitalsignsList", vitalSignsService.getAllVitalSigns());
        map.put("anthropometricdata", anthropometricData);
        map.put("anthropometricdataList", anthropometricDataService.getAllAnthropometricData());
    }