@RequestMapping(method = RequestMethod.PUT, value = "/update")  
public String update(@ModelAttribute("entity") @Valid Entity entity) {
            service.update(entity);
            return "redirect:desiredMethod"; 
//desiredMethod is GET method that renders needed page
        }