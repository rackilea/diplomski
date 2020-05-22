@Override
public Optional<User> getCurrentAuditor() {
    User auditor = null;
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            auditor = (User) principal;
        }
    }
    return Optional.ofNullable(auditor);
}