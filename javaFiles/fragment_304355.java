@RequestMapping(value = "/", method = RequestMethod.GET)
public ModelAndView home(Locale locale, Model model) {

    Object theTempBean = new Object(){
        public String key = "blahblahblah";

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    };

    model.addAttribute("theTempBean", theTempBean);

    String viewName = "home";
    return new ModelAndView(viewName, "command", model);
}