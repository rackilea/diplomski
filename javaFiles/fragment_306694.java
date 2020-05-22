private static final Form<MobileWriteReview> MOBILE_WRITE_REVIEW_FORM = Form.form(MobileWriteReview.class); // this field declared as final

public static Result review(){
    MobileWriteReview mobileWriteReview = new MobileWriteReview(4);
    Logger.info("Mobile Write Review grade = " + mobileWriteReview.grade);

    // this is proper way to fill the form using existing value
    return ok(views.html.mobileInviteToReview.render(MOBILE_WRITE_REVIEW_FORM.fill(mobileWriteReview)));
}

public static Result doReview(){
    final Form<MobileWriteReview> filledForm = MOBILE_WRITE_REVIEW_FORM.bindFromRequest();
    MobileWriteReview mobileWriteReview = filledForm.get();
    Logger.info("Grade submitted = " + mobileWriteReview.grade);

    if (filledForm.hasErrors()) {
        // User did not fill everything properly
        return badRequest(views.html.mobileInviteToReview.render(filledForm));
    } else {
        // Everything was filled
        return ok("Grade submitted = " + mobileWriteReview.grade);
    }
}