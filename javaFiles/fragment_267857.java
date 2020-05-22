@Component
public class A implements Wisher{
    public String wish(int timeHr){
       //some logic of time based wish
    return "Hello A"+" good morning";
}


@Component
public class B implements Wisher{
    public String wish(int timeHr){
       //some logic of time based wish
    return "Hello B"+" good morning";
}
}

@Component
public class C implements Wisher{
    public String wish(int timeHr){
       //some logic of time based wish
    return "Hello C"+" good morning";
}
}

public interface Wisher{ public String wish(int time); }

@Service
public class MyService{
   @Autowired
   private List<Wisher> wishers;

void myMethod() {
    String requiredClassName = "A";
    Wisher requiredWisher = null;
    for (int i = 0; i < wishers.length(); i++) {
        Wisher w = wishers.get(i);
        if (w.getClass().getName().equals(requiredClassName)) {
            requiredWisher = w;
            break;
        }

        System.out.println(w.wish(123));
    }
}



    }