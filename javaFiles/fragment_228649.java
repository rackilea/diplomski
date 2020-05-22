@RequestMapping("/login")
public String login(@ModelAttribute("loginUser") User user,
    BindingResult result, @ModelAttribute("signUpUser") User signUpUser,
    BindingResult signUpResult, ModelMap model, HttpServletRequest request,
    HttpServletResponse response) {

// Here, both user and signUpUser have the same value (WHY?)
// But I dint fill the sign up form at all

loginFormValidator.validate(user, result);

if(Errors in `result`)
    return "forward:/home";

// Authentication Logic
request.getSession().setAttribute("s_user_obj", some_variable);
return "forward:/home";