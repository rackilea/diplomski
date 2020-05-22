@CrossOrigin 
@PostMapping(LOGIN_URL)
public ResponseEntity getAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest)
        throws AuthenticationException {
    System.out.println("on login server side");
   ...
}