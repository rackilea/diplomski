public class AuthenticationInterceptor implements Interceptor {

@Override
public void destroy() {

}

@Override
public void init() {

}

@Override
public String intercept(ActionInvocation actionInvocation)
        throws Exception {

    Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();

    User user = (User) sessionAttributes.get("user");

    if(user == null){
        return Action.LOGIN;
    }else{
        Action action = (Action) actionInvocation.getAction();
        if(action instanceof UserAware){
            ((UserAware) action).setUser(user);
        }
        return actionInvocation.invoke();
    }
}

}