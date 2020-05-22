@AroundInvoke
public Object log(InvocationContext ctx) throws Exception {
    String originName = Thread.currentThread().getName();
    String currentUser = context.getCallerPrincipal().getName();
        try{
           String tracingName = currentUser + " " + originName;
           Thread.currentThread().setName(tracingName);
           return ctx.proceed();
        }finally{
            Thread.currentThread().setName(originName);
        }
    }