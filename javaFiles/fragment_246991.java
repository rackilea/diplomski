@Controller
public class Controller {
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private TipoService tipoService;
    @Autowired
    private UsuarioService usuarioService;