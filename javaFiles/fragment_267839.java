@ManagedBean
@ApplicationScoped
public class SimpleEntityGroupConverter implements Converter {
    private static final Logger L = Logger.getLogger(SimpleEntityGroupConverter.class);

    @EJB
    private SimpleEntityDao ed;