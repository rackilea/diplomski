public abstract class AbstratoResource<ID, E extends Entidade<ID>, S extends IAbstratoService<E>> {

    @Autowired
    protected S service;

    @GetMapping("/carregarTodos")
    public List<E> carregarTodos() {
        return this.service.carregarTodos();
    }

    @GetMapping("/carregarPeloCodigo/{id}")
    public Optional<E> carregarPeloCodigo(@PathVariable("id") ID id) {
        return this.service.carregarPeloCodigo(id);
    }

    @PostMapping("/inserir")
    public void inserir(E entidade) {
        this.service.inserir(entidade);
    }

    @PutMapping("/atualizar")
    public void atualizar(E entidade) {
        this.service.atualizar(entidade);
    }

    @DeleteMapping("/deletar")
    public void deletar(ID id) {
        this.service.deletar(id);
    }
}

public interface IAbstratoService<E> {

    public List<E> carregarTodos();
    public Optional<E> carregarPeloCodigo(ID id);
    public void inserir(E entidade);
    public void atualizar(E entidade);
    public void deletar(ID id);

}

public class AbstratoServiceImpl<ID, T extends Serializable, E extends Entidade<ID>, R extends AbstratoRepository<E>>
        implements IAbstratoService<E> {

    @Autowired
    private R repositorio;

    @Override
    public List<E> carregarTodos() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<E> carregarPeloCodigo(ID id) {
        return this.repositorio.findById(id);
    }

    @Override
    public void inserir(E entidade) {
        this.repositorio.save(entidade);
    }

    @Override
    public void atualizar(E entidade) {
        this.repositorio.save(entidade);
    }

    @Override
    public void deletar(ID id) {
        this.repositorio.deleteById(id);
    }
}

@Service
public class CachorroService extends AbstratoServiceImpl<Long, Cachorro, CachorroRepository> {
}