SecurityContext secureContext = SecurityContextHolder.getContext();
Authentication auth = secureContext.getAuthentication();
Object principal = auth.getPrincipal();

String userName = null;
if (principal instanceof UserDetails) {
    UserDetails userDetails = (UserDetails) principal;
    userName = userDetails.getUsername();
} else {
    userName = principal.toString();
}