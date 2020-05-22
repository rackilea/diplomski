@RequestMapping("/somePage")
public String getSomePage(Model model, HttpServletRequest request) {

    Principal principal = request.getUserPrincipal();
    if (principal != null) {

        User activeUser = userService.getUserByPhone(principal.getName());
        // ...

    } else { // user is not authenticated
        System.out.println("user is not authenticated to proceed the somePage!!!!!!!");
        return "redirect:/";
    }
}