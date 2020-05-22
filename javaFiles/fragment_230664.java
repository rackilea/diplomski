private final static Experience INSTANCE;
public final static Logger LOGGER;

static {
    LOGGER = Logger.getLogger(Experience.class.getName());
    LOGGER.setLevel(Level.SEVERE);
    INSTANCE = new Experience();
}