@Component
public class MyAuthoritiesExtractor implements AuthoritiesExtractor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
        String role = "ROLE_USER";
        Optional<Long> principalId = getPrincipalId(map);
        if (principalId.isPresent()) {
            User user = userRepository.findOne(principalId.get());
            role = (user != null && user.isAdmin()) ? "ROLE_ADMIN" : "ROLE_USER";
        }

        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    private Optional<Long> getPrincipalId(Map<String, Object> map) {
        try {
            return Optional.of(Long.parseLong(map.getOrDefault("id", "").toString()));
        } catch (Exception ex) {
            // log
            return Optional.empty();
        }
    }
}