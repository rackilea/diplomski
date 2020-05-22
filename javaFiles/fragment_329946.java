public ModelAndView redirectToSomewhere() {
    RedirectView redirectView = new RedirectView("/my/form/newpage.html?pid=".concat(myform.getId().toString());
    redirectView.setExposeModelAttributes(false); // these
    redirectView.setExposePathVariables(false); //two depend on the way you set your variables
    return new ModelAndView(redirectView);
}