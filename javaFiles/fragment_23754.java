public String activate(Map<String, String> model, @PathVariable String code) {
    boolean isActivated = userService.activateUser(code);
    // TODO: change to boolean in template
    if (isActivated) {
        model.put("message", "User Successfully activated");
    } else model.put("message", "Activation code not found");
     model.put("isActivated", isActivated);

    return "verificationPage";
}