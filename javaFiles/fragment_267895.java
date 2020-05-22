@Service
public class ClientService implements ClientDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        var cliente = clienteRepository.findById(clientId);


        var clienteDetail = new ClienteDetalhes(
                cliente.get().getClientId(),
                String.join(",", cliente.get().getResourceIds()),
                cliente.get().getClientSecret(),
                String.join(",", cliente.get().getScope()),
                String.join(",", cliente.get().getAuthorizedGrantTypes()),
                String.join(",", cliente.get().getRegisteredRedirectUri()),
                null,
                cliente.get().getAccessTokenValiditySeconds(),
                cliente.get().getRefreshTokenValiditySeconds(),
                cliente.get().getAutoApproveScope(),
                null);
        return clienteDetail;

    }
}