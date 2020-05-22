@PreAuthorize("isAuthenticated()") 
    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public @ResponseBody Users getCurrentLoggedInUser() throws Exception {
        Object authenticatorPrincipalObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = null;
        if(authenticatorPrincipalObject != null && authenticatorPrincipalObject instanceof Users){
            Users authenticatorPrincipal = (Users) authenticatorPrincipalObject;
            userName = authenticatorPrincipal.getUsername();
        }else if(authenticatorPrincipalObject != null){
            userName =  authenticatorPrincipalObject.toString();
        }else{
            return null;
        }
        return userService.getCurrentLoggedInUser(userName);
    }