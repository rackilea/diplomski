@GetMapping(value = "{user}")
    public String edit(@PathVariable Long userId, Model model) {
        User user = //user userId to fetch
        model.addAttribute("user", user);
        return "userEdit";
}