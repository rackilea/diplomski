@Autowired
    private LdapUserSearch ldapUserSearch;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    public void initialise()
    {
        DirContextOperations dirContextOperations = ldapUserSearch.searchForUser( "username" );

        Authentication authentication = authenticationProvider.authenticate( new UsernamePasswordAuthenticationToken( "username", "password" ) );    
    }