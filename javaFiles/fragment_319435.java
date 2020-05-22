@RequestMapping("/account/register")
public String registerPost(
        @ValidModifyingVerb RegisterForm registerForm,
        BindingResult result,
        RedirectAttributes redirectAttributes) {

    //... ADD USER HERE IF !result.hasErrors() ...

    return "account/register";
}