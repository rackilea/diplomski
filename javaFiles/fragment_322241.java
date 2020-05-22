if(validation.hasError("name_of_username_form_field")){
    flash.error("Username required");
    login();
}else if (validation.hasError("name_of_password_form_field")){
    flash.error("Password required");
    login();
}