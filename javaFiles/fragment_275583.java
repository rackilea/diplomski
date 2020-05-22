package vijay.controller;

import vijay.beans.PropertyDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import vijay.configuration.PropertyApplicationContext;

/**
 * Property List Controller.
 * @author Vijay
 */
@Controller
public class PropertyController {   

    @RequestMapping("/")
    public String testController(){
        System.out.println("vijay.controller.PropertyController.testController()");
        return "sample";
    }


    @RequestMapping(path = "/getProperties") 
    public String testPropertiesController(ModelMap modelMap){
        ApplicationContext applicationContext = PropertyApplicationContext.getInstance().getApplicationContext();
        PropertyDto propertyDto = (PropertyDto) applicationContext.getBean("propertyBean");
        System.out.println("vijay.controller.PropertyController.testPropertiesController() " + propertyDto);
        modelMap.addAttribute("message", propertyDto.getKey());
        return "sample";
    }

    /**
     * Method will refresh ApplicationContext
     * @param modelMap as ModelMap
     * @return viewName as String
     */
    @RequestMapping(path = "/refreshProperties") 
    public String refreshBean(ModelMap modelMap){
        ApplicationContext applicationContext = PropertyApplicationContext.getInstance().getApplicationContext();
        // Refresh Application Context
        ((ConfigurableApplicationContext)applicationContext).refresh();
        PropertyDto propertyDto = (PropertyDto) applicationContext.getBean("propertyBean");
        System.out.println("vijay.controller.PropertyController.refreshBean()" + propertyDto);
        modelMap.addAttribute("message", propertyDto.getKey());
        return "sample";
    }

}