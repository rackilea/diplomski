@Component("A")
public class A{
    public String wish(int timeHr){
       //some logic of time based wish
    return "Hello A"+" good morning";
}


@Component("B")
public class B{
    public String wish(int timeHr){
       //some logic of time based wish
    return "Hello B"+" good morning";
}
}

@Component("C")
public class C{
    public String wish(int timeHr){
       //some logic of time based wish
    return "Hello C"+" good morning";
}
}


@Service
public class MyService{
   @Autowired
   private ApplicationContext context;

  void myMethod() {
    A a = (A) context.getBean("A");


     System.out.println(a.wish(123));
   } 
    }