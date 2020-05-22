@RequestMapping(value = "/ControllerURL", method = RequestMethod.GET, headers="Accept=application/xml, application/json")
public @ResponseBody DealManager homeXmlJson(Locale locale, Model model) {

       MyClass myClass = new MyClass();
           myClass.setTitle("SUCCESS");

    return myClass;
}