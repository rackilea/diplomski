public class Groups {
    private List<Group> list = new AutoPopulatingList<Group>(Group.class);  
    ...    
}

@RequestMapping(value = "/test", method = RequestMethod.GET)  
public ModelAndView test(  
    @ModelAttribute Groups groups  
) {   
 //return whatever  
}