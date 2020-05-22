/**
 * Custom handler for displaying vets.
 * Note that this handler returns a plain {@link ModelMap} object instead of
 * a ModelAndView, thus leveraging convention-based model attribute names.
 * It relies on the RequestToViewNameTranslator to determine the logical
 * view name based on the request URL: "/vets.do" -> "vets".
 * @return a ModelMap with the model attributes for the view
 */
@RequestMapping("/vets.do")
public ModelMap vetsHandler() {
    return new ModelMap(this.clinic.getVets());
}