package controllers;

import play.data.*;
import play.mvc.*;
import views.html.login;


public class Application extends Controller {

    public Result login() {
        return ok(
            login.render(
                Form.form(Login.class)
            )
        );
    }

    public Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        return ok();
    }

}