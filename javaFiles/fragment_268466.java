@Bean
public AuditorAware<String> auditAware(){
    return () -> {
        if (SecurityContextHolder.getContext() == null || SecurityContextHolder.getContext.getAuthentication() == null) {
            return Optional.of("system");
        } else {
            return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
        }
    }
}