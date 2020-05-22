@PostMapping("/signin/facebook")
public ResponseEntity<?> signInWithFacebook(@Valid @RequestBody FBLoginRequest loginRequest) {

    // Call facebook's API to validate id_token and get user's details

    // Register new user (Note: Also add code to check if a user already exists with the given facebookId )
    User user = new User(fbName, fbID,
            emailId, null);
    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
            .orElseThrow(() -> new AppException("User Role not set."));
    user.setRoles(Collections.singleton(userRole));

    User result = userRepository.save(user);

    // Authenticate User
    UserPrincipal userPrincipal = UserPrincipal.create(result);
    PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // Generate and return token
    String jwt = tokenProvider.generateToken(authentication);
    return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
}