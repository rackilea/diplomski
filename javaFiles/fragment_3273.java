@Controller
@RequestMapping(value = "/user")
class UserController {

    @Cacheable(value = "users", key = "#id")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUser(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Last-Modified", dateFormat.format(new Date()));
        return new ResponseEntity<SecurityProperties.User>(headers, userService.get(id), HttpStatus.OK);
    }
}