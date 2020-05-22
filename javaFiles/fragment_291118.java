final String cId = form().bindFromRequest().get("customer.id");
if (filledLoginForm.hasGlobalErrors()
        || cId==null || cId.equals("")) {
    // in this case either there were some validation errors or the provided customer.id is not valid
    return badRequest(yourTemplateHere.render(filledLoginForm));
}