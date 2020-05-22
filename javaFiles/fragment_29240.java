@GetMapping("users")
 public List<UserDto> findUsers(
    @RequestParam("countries", required = false) List<String> countryCodes,
    @RequestParam("groupIds", required = false) List<Long> groupsIds) {
if(countryCodes == null){
    countryCodes = fetchCountryCodeFromRepo();
}
if(groupIds == null){
    groupIds = fetchGroupIdsFromRepo();
}
return matchingService.findMatchingUsersBy(groupIds, countryCodes);
}