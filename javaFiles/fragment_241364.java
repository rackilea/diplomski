@Autowired
@Qualifier("authenticationManager")
@Override
public void setAuthenticationManager(AuthenticationManager authenticationManager) {
    super.setAuthenticationManager(authenticationManager);
}