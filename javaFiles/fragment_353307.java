public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
  ActionErrors errors = new ActionErrors();
  if ((username==null) || (username.length() < 1)) 
      errors.add("username", new ActionError("error.username.required"));
  return errors;
}