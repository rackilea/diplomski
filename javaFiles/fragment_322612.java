public static User currentUser() {
    if (SecurityContextHolder.getContext() != null && 
            SecurityContextHolder.getContext().getAuthentication() != null && 
            SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null &&
            SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
        //logger.debug(className, "currentUser", "User: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    } else {
        return null;
    }
}