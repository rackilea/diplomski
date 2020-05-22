@Repository(value = "usuarioDao")
public class UsuarioDaoImp implements UsuarioDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UsuarioDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    ...

}