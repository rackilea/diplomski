@RequestMapping(value="/delete/{userLogin}", method=RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public void deleteUser(@PathVariable String userLogin) {
    userService.remove(userService.findByLogin(userLogin));
}