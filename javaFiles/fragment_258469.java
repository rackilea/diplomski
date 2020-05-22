@RequestMapping(path = "/get_data_on_login", method = RequestMethod.GET)
public ResponseEntity get_data_on_login(
       @RequestParam(value="username") String userName) throws Exception {
  List<TopicBean> topics = topicService.findAllTopics( userName );
  List<UserRoleBean> roles = roleService.findAllRoles( userName );
  return new ResponseEntity( new LoginData( topics, roles ), HttpStatus.OK );
}