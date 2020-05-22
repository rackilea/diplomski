String userName = "";
    String autoridade = "";

    SecurityContext context = SecurityContextHolder.getContext();
    if (context instanceof SecurityContext) {
        authentication = context.getAuthentication();
        if (authentication instanceof Authentication) {

            userName = (((UserDetails) authentication.getPrincipal()).getUsername());
            autoridade = (((UserDetails) authentication.getPrincipal()).getAuthorities().iterator().next().getAuthority());

        }
    }