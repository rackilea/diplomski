@Value(HEARTBEAT_SECONDS)
long secondsBetweenHeartbeats;
@Autowired
ServerSocket socket;
@Autowired
PlayerRepository playerRepository;
@Autowired
DeckProcessor deckProcessor;
@PostConstruct
public void init() {
  this.serverSocket = socket;
  this.maintainer = new Maintainer(secondsBetweenHeartbeats);
  this.playerRepository = playerRepository;
  final ExecutorService executorService = newCachedThreadPool();
  executorService.execute(this);
  this.running = true;

  this.deckProcessor = deckProcessor;
  executorService.execute(maintainer);
}