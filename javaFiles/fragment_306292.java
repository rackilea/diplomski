@DataJpaTest
@RunWith(SpringRunner.class)
public class WhatsappChatRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    WhatsappChatRepository whatsappChatRepository;

    @Before
    public void setup() {
        entityManager.persist(new WhatsappChat("whats1", "whats01", 1));
        entityManager.persist(new WhatsappChat("whats2", "whats02", 2));
        entityManager.persist(new WhatsappChat("whats3", "whats01", 3));
        entityManager.persist(new WhatsappChat("whats4", "whats04", 4));

        entityManager.flush();
    }

    @Test
    public void shouldTestSameResult() {
        assertEquals(whatsappChatRepository.findDistinctWhatsappIds(), whatsappChatRepository.findDistinctWhatsappIdsNative());

        assertEquals(Arrays.asList("whats01", "whats02", "whats04"), whatsappChatRepository.findDistinctWhatsappIds());
    }
}