@GetMapping("/profile")
public String getProfile(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession(false);
    String email = (String) session.getAttribute("userId");
    User user = userService.getProfile(email);
    session.setAttribute("user", user);
    model.addAttribute("session", session);
    return "user/profile";
}