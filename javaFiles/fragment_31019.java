@Override
public String intercept(ActionInvocation invocation) throws Exception {

    try{
        return super.intercept(invocation);
    }catch(IllegalStateException ex){
        return Action.ERROR; 
    }

}