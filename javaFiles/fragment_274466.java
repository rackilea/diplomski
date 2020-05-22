@RequestMapping(value="/submit", method = RequestMethod.POST)    
public ModelAndView submitForm(@ModelAttribute("shape") Shape shape){
         if(shape instanceof Round){ //**Not giving positive result**

         }
    }