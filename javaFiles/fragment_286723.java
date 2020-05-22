UserForm user = new UserForm();
//set value of Geschlecht
user.Geschlecht = Mann;

Form<UserForm> form = Form.form(UserForm.class);
form.fill(user)

Html view = views.index.render(userForm);