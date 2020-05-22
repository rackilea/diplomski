@RestController
@RequestMapping("/strategies")
public class StrategyController {
    ...

    @GetMapping
    public List<Strategy> getAll() {
        return service.getBeans().stream()
            .map(mapper::toDto)
            .collect(toList());
    }

    @GetMapping
    public List<Strategy> search(@RequestParam CODE_TYPE code, @RequestParam String name, @RequestParam TYPE_TYPE type, StrategySearchSpecification specification ) {
        specification.setCode( code );
        specification.setName( name );
        specification.setType( type );
        return service.search( specification
            )).stream()
            .map(mapper::toDto)
            .collect(toList());
    }
}