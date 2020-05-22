@PutMapping("/users/{id}")
@ResponseStatus(HttpStatus.ACCEPTED)
@PreAuthorize("#updatedUser.userId == principal.userId")
public User updateUser(@PathVariable("id") Long userId, @RequestBody User updatedUser){

}