Form<User> uf = Form.form(User.class);

Form<User> newUf = uf.fill( new User( "felix@abc.com" , "123") );

if (newUf.hasErrors()){
    return ok("Form Error");
}

// Should Work
newu=Uf.get();