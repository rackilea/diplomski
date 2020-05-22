@Component
@Profile("!test") // Add this
public class GameRunner implements CommandLineRunner {
    @Autowired
    GameClient gameClient;

    @Override
    public void run(String...args) throws Exception {
        gameClient.runGame();
    }
}