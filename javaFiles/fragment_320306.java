@Service
public class B {

  @Autowired
  public B(A a) {
     a.doSomething();
  }
}