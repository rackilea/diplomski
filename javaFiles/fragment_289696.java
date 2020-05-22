private String getUserName() {
    Authentication authentication = 
    SecurityContextHolder.getContext().getAuthentication();
    UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
    return userPrinciple.getUsername();
}