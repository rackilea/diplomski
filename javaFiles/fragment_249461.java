@EJB(name = "collaborateurFacadeLocal", beanInterface = CollaborateurFacadeLocal.class)
public class SiUserDetailsService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(SiUserDetailsService.class);
    private CollaborateurFacadeLocal collaborateurFacade;

    private static final String COLLABORATEUR_EJB_LOOKUP_PATH = "java:comp/env/collaborateurFacadeLocal";

    @Override
    public UserDetails loadUserByUsername(String userName) {
        User user;
        Collaborateur collab = getUser(userName);
        if (collab == null) {
            throw new UsernameNotFoundException(userName + " not found");
        }
        user = new User(collab);
        if (user == null) {
            throw new UsernameNotFoundException(userName + " not found");
        }
        return user;
    }

    private Collaborateur getUser(String userName) {
        try {
            InitialContext initialContext = new InitialContext();
            collaborateurFacade = (CollaborateurFacadeLocal) initialContext.lookup(COLLABORATEUR_EJB_LOOKUP_PATH);
            return collaborateurFacade.findUserByUserName(userName);
        } catch (NamingException ex) {
            logger.error("Could not lookup for EJB CollaborateurFacadeLocal with lookup path " + COLLABORATEUR_EJB_LOOKUP_PATH);
        }
        return null;
    }
}