public class FooRepositoryImpl implements FooRepositoryCustom {
@Autowired
private FooRepository fooRepository;
public Foo findByMyObject(MyObject obj) {
    return new Foo(fooRepository.findByMyField(obj.getId()));
  }
}