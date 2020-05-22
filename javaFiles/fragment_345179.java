@RequestMapping(value = "/PostJSONMAV", method = RequestMethod.POST)
public  ModelAndView postJSON(@RequestBody MyClass myClass) {
    ModelAndView mav = new ModelAndView();
    myClass.setTitle("SUCCESS");
    mav.setViewName("dialogContent");
    mav.addObject("myClass", myClass);
    return mav;     
}