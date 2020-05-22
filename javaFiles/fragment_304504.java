@Controller
    public class C1{
         @AutoWired
         C2 c2;

         @RequestMapping("/")
         public String home(){
            c2.start();
            System.out.println("something");
            return "home";
         }
    }
}

@Component
@Scope
public class C2 extends Thread{
  @Override
  public void run(){
    while(true){
       System.out.println("random stuff");
    }
  }
}