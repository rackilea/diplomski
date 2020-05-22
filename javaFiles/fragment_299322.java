@Component(immediate=true, property="main.thread=true")
 public class Main implements Runnable {
     String[] args;

     public void run(){ ... }

     @Reference(target="(launcher.arguments=*)")
     void setArgs(Object service, Map<String,Object> props) {
        this.args = (String[]) props.get("launcher.arguments");
     }
 }