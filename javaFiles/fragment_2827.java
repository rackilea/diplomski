@RequestMapping(<some pattern>)
public ModelAndView loadData( @SessionAttribute(value="data", required=false) Data data, 
           @RequestParam("action") String action) {
    if (data == null) {
       Data data = new Data();
       session.setAttribute("data", data);
    }
    //additional processing using data
    return ...
}