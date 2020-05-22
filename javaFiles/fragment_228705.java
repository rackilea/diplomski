this.localityContext = (LocalityRequest) driver.flush(); //Flush the request
Set<ConstraintViolation<LocalityProxy>> violations = validator.validate(this.modifedLocality); //Local validate the mutable Proxy
if (!violations.isEmpty()) {
    Set<ConstraintViolation<?>> sets = new HashSet<ConstraintViolation<?>>(violations);
    driver.setConstraintViolations(sets);
    editLocalityView.setErrors(sets); //give errors to the editors
    return;
}
localityContext.fire(); //else send the request