@helper.form(action = routes.Application.submit(), 'id -> "userForm"){
        <fieldset>
            @helper.inputRadioGroup(
            userForm("Geschlecht"),
            options = options("Mann"->"Mann","Frau"->"Frau"),
            '_label -> "Gender",
            '_error -> userForm("Geschlecht").error.map(_.withMessage("select gender"))
            )
        </fieldset>