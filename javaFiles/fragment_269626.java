public class BaseController<Model> {

    @Autowired
    protected JpaRepository<Model, Long> repository;

}

@Controller
public class AdminController extends BaseController<Admin> {

}