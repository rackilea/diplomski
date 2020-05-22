@(title: String, formSignup: Form[models.commerce.CommerceSignupRequest])

@import play.data.Form
@import helper._

@implicitField = @{ FieldConstructor(myField.f) }

@main(title) {
    <div class="container">
        @form(action = routes.CommerceController.signup()) {
            <fieldset>
                <legend>@title</legend>
                @inputText(formSignup("commerceName"))
                @inputText(formSignup("blabla1"))
                @inputText(formSignup("blabla2"))
            </fieldset>
            <button type="submit" id="submit-btn" name="submit" class="btn">Send</button>
        }
    </div>
}