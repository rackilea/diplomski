private int parameter;

@Override
public void doAfterCompose(Component window) throws Exception {
    super.doAfterCompose(window);
    if (arg.containsKey("parameter")) {
        parameter =  (int) arg.get("parameter"));
    } else {
       //Declare what is is when you don't have the arg
    }    
}