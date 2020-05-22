PrivateRoomController {

    @RequestMapping(value = "/save-user-two", method = RequestMethod.POST)
    public ModelAndView saveUser(UserBean user, HttpSession session) {

        // Retrieve user object in the user's session
        UserBean userFromSession = session.getAttribute("user");

        // Update some additional values
        userFromSession.setUserName(user.getUserName());
        userFromSession.setUserSurename(user.getUserSurename());
        userFromSession.setUserDateOfBirth(user.getUserDateOfBirth());

        // Save to database at once
        userService.saveUser(userFromSession);

        return new ModelAndView("privateroom");
    }

}