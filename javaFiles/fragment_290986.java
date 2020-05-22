@RequestMapping("/{id}")
 public String get(@PathVariable("id") Long personId, Model model,HttpSession session, HttpServletRequest request) {

    request.setAttribute("personId", personId);
    Person person = personService.findById(personId);

    /* DO STUFF HERE */

    return "person.show";
} 

@ExceptionHandler(AccessDeniedException.class)
 public ModelAndView accessDeniedHandler(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("accessDeniedView");
    Long personId = request.getAttribute("personId");
    // populate your model
    return mav;
}