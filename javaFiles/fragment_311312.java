@InitBinder
public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);

    // true passed to CustomDateEditor constructor means convert empty String to null
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
}