@InitBinder
public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(
            dateFormat, true));
}