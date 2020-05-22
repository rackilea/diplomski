@Component
public class MyOAuthAuthenticationHandler implements OAuthAuthenticationHandler {    
    final static Logger log = LoggerFactory.getLogger(MyOAuthAuthenticationHandler.class);

    static SimpleGrantedAuthority userGA = new SimpleGrantedAuthority("ROLE_USER");
    static SimpleGrantedAuthority adminGA = new SimpleGrantedAuthority("ROLE_ADMIN");

    @Override
    public Authentication createAuthentication(HttpServletRequest request, ConsumerAuthentication authentication, OAuthAccessProviderToken authToken) {
        Collection<GrantedAuthority> authorities = new HashSet<>(authentication.getAuthorities());
        // attempt to create a user Authority
        String username = request.getParameter("username");
        if (StringUtils.isBlank(username)) {
            username = authentication.getName();
        }

        // NOTE: you should replace this block with your real rules for determining OAUTH ADMIN roles
        if (username.equals("admin")) {
            authorities.add(userGA);
            authorities.add(adminGA);
        } else {
            authorities.add(userGA);
        }

        Principal principal = new NamedOAuthPrincipal(username, authorities,
                authentication.getConsumerCredentials().getConsumerKey(),
                authentication.getConsumerCredentials().getSignature(),
                authentication.getConsumerCredentials().getSignatureMethod(),
                authentication.getConsumerCredentials().getSignatureBaseString(),
                authentication.getConsumerCredentials().getToken()
        );
        Authentication auth = new UsernamePasswordAuthenticationToken(principal, null, authorities);
        return auth;
    }

    public static class NamedOAuthPrincipal extends ConsumerCredentials implements Principal {
        public String name;
        public Collection<GrantedAuthority> authorities;

        public NamedOAuthPrincipal(String name, Collection<GrantedAuthority> authorities, String consumerKey, String signature, String signatureMethod, String signatureBaseString, String token) {
            super(consumerKey, signature, signatureMethod, signatureBaseString, token);
            this.name = name;
            this.authorities = authorities;
        }

        @Override
        public String getName() {
            return name;
        }

        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }
    }
}