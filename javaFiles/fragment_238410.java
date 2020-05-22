@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClientRequestFactoryForId {
    public int value();
}

@Service
@ClientRequestFactoryForId(1)
public class AccountLoginClientRequestFactory implements ClientRequestFactory {

    @Override
    public ClientRequest createClientRequest(ByteBuffer data, ClientConnection client, int id) {
        new CM_ACCOUNT_LOGIN(data, client, id);
    }
}

@Service
public class ClientRequestSwitchboard {

    private final Map<Integer, ClientRequestFactory> mappings = new HashMap<>();
    private final ListableBeanFactory beanFactory;

    @Autowired
    public ClientRequestSwitchboard(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @PostConstruct
    @SuppressWarnings("unchecked")
    private void findAllClientRequestFactories() {
        Map<String, Object> factories = beanFactory.getBeansWithAnnotation(ClientRequestFactoryForId.class);

        for (Object factory: factories.values()) {
            int id = dataStore.getClass().getAnnotation(ClientRequestFactoryForId.class).value();

            if (factory instanceof ClientRequestFactory) {
                mappings.put(id, (ClientRequestFactory) factory);
            }
            else {
                throw new IllegalStateException("Found object annotated as @ClientRequestFactoryForId but was not a ClientRequestFactory instance: " + factory.getClass().getName());
            }
        }
    }

    public ClientRequest createClientRequest(ByteBuffer data, ClientConnection client, int id) {
        ClientRequestFactory factory = mappings.get(id);

        if (factory == null) {
            return createDefault(data, client, id);
        }
        else {
            return request.createClientRequest(data, client, id);
        }
    }

    protected ClientRequest createDefault(ByteBuffer data, ClientConnection client, int id) {
        logUnknownRequest(client, id);
        return null;
    }
}