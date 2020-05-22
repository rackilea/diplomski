@RequestMapping("/create")
 @ResponseBody
 public String create(@RequestBody User user) {
   String userId = "";
   try {
        userRepository.save(user);
        userId = String.valueOf(user.getId());
    } catch (Exception ex) {
          return "Error creating the user: " + ex.toString();
     }
        return "User succesfully created with id = " + userId;
  }