@GetMapping("/account")
    @SuppressWarnings("unchecked")
    public UserDTO getAccount(Principal principal) {
        if (principal instanceof OAuth2AuthenticationToken) {
            return userService.getUserFromAuthentication((OAuth2AuthenticationToken) principal);
        } else if (principal instanceof JwtAuthenticationToken) {
            return userService.getUserFromAuthentication((JwtAuthenticationToken) principal);
        } else {
            throw new AccountResourceException("User could not be found");
        }
    }