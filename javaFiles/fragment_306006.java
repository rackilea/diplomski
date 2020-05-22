@ModelAttribute
public User getUser(@PathVariable Long id) {
  return getUser(id);
}

@PatchMapping("/users/{id}/update")
public ResponseEntity<?> updateUser(@ModelAttribute User user) {
    userService.save(user);
    response = new ApiResponse(true, "SUCCESSFUL_UPDATED");
    return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
}