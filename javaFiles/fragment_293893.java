@RequestMapping(value = "/loadbranches", method = RequestMethod.GET)
public ModelAndView getBranches(@RequestParam(value="branches") String branches) 
    {

        ....
    }