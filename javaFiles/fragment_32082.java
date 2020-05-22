public static Result contact() {
    Form<Contact> contactForm = form(Contact.class).bindFromRequest();
    if (contactForm.hasErrors()) {
        // process
    } else {
        // contactForm.get().firstName should be filled with the correct data
        return ok(views.html.contact.render("message", contactForm)); 
    }
}