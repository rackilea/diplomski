//...
private ClientesRepository clientesRepository;

@Mock
private EntityManager manager;

@Before
public void init() {
    MockitoAnnotations.initMocks(this);
    clientesRepository = new ClientesRepository(manager);
}
@Test
public void testBuscarPorId() {
    Cliente expected = new Cliente(1, ...);

    Mockito.when(manager.find(Cliente.class, new Long(1))).thenReturn(expected);

    Cliente clientePesquisado = clientesRepository.buscarPorId(new Long(1));

    assertEquals(Long.valueOf(1), clientePesquisado.getId());

}