@RunWith(SpringJUnit4ClassRunner.class)
    @SpringApplicationConfiguration(classes = {
        Application.class, 
        TestMongoConfig.class // <--- Don't forget THIS
    })
    public class GameRepositoryTest {

        @Autowired
        private GameRepository gameRepository;

        @Test
        public void shouldCreateGame() {
            Game game = new Game(null, "Far Cry 3");
            Game gameCreated = gameRepository.save(game);
            assertEquals(gameCreated.getGameId(), gameCreated.getGameId());
            assertEquals(game.getName(), gameCreated.getName());
        }

    }