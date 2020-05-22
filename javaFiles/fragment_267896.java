@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "cliente")
public class ClienteDetalhes implements Serializable, ClientDetails {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Id
    @Column(nullable = false, unique = true)
    private String clientId;
    private String resourceIds;
    private String clientSecret;
    private String scope;
    @Column(nullable = false)
    private String authorizedGrantTypes;
    private String registeredRedirectUri;
    private String authorities;
    @Column(nullable = false)
    private Integer accessTokenValiditySeconds;
    @Column(nullable = false)
    private Integer refreshTokenValiditySeconds;
    private String autoApproveScope;
    private String additionalInformation;

    @Override
    public boolean isSecretRequired() {
        return !StringUtils.isEmpty(this.clientSecret);
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        try {
            return mapper.readValue(this.additionalInformation, Map.class);
        } catch (IOException e) {
            return new HashMap<>();
        }
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Set<String> set = StringUtils.commaDelimitedListToSet(this.authorities);
        Set<GrantedAuthority> result = new HashSet<>();
        set.forEach(authority -> result.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return authority;
            }
        }));
        return result;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return StringUtils.commaDelimitedListToSet(this.registeredRedirectUri);
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return StringUtils.commaDelimitedListToSet(this.authorizedGrantTypes);
    }

    @Override
    public boolean isScoped() {
        return this.getScope().size() > 0;
    }

    @Override
    public Set<String> getScope() {
        return StringUtils.commaDelimitedListToSet(this.scope);
    }

    @Override
    public Set<String> getResourceIds() {
        if (StringUtils.isEmpty(this.resourceIds)) {
            return new HashSet<>();
        } else {
            return StringUtils.commaDelimitedListToSet(this.resourceIds);
        }
    }

}