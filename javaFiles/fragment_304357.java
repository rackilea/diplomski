@RequestMapping(path = "/myAction")
public String myAction(@RequestParam("key") String param
        , Model model){
    logger.info(param);

    Object theTempBean = new Object(){
        public String key = param;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    };

    model.addAttribute("theTempBean", theTempBean);

    return jspViewName("home");
}