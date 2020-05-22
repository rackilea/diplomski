String subject = claims.get().getSubject();
if (subject == null) {
    throw new BadCredentialsException(
        "The authentication token " + optToken + " did not contain a subject.");
}

UsernamePasswordAuthenticationToken authentication = ... ;