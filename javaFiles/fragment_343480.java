public abstract class Actor{
    public abstract void action(String[] args);
}

public class Actor2 extends Actor{

    public void action(String[] args){
        if(args != null && args.length > 0 && args[0].equals("SPECIAL_CASE"){
            //Do special case things
        } else {
            //Do regular case things
        }
    }
}