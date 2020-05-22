if (bindingResult.hasErrors()) {
   return "userEdit";
} else {
    User userDB = userService.findUserById(userId);
    //compare the new & db values 
    //i.e., userForm and userDB and then update to userDB
    //userDB.setX(userForm.getX());
    //IGNORE PWD FIELDS, DO NOT UPDATE THEM TO userDB object
    userService.save(userDB);
    status.setComplete();
    return "redirect:/users/" + userId;
}