@(inviteForm: Form[models.MobileWriteReview])
@import views.html.helper._

@main(title = "Input Radio Group Sample") {
   @form(action = routes.Application.doReview()) {
      @****** This helper can accomodate selected value of radio button if present *****@
      @inputRadioGroup(
         inviteForm("grade"),
         options = options("1" -> "1", "2" -> "2", "3" -> "3", "4" -> "4", "5" -> "5")
      )

      <input type="submit" value="Post">
    }
}