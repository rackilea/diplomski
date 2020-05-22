package br.com.ar.aop;

@Aspect
public class HibernateInterceptorAdvice {

     @Autowired
     private HibernateInterceptor hibernateInterceptor;

     /**
       * I suppose your DAO's live in com.app.dao package
       */
     @Around("execution(* com.app.dao.*(..))")
     public Object interceptCall(ProceedingJoinPoint joinPoint) throws Throwable {
         ProxyFactory proxyFactory = new ProxyFactory(joinPoint.getTarget());
         proxyFactory.addAdvice(hibernateInterceptor);

         Class [] classArray = new Class[joinPoint.getArgs().length];
         for (int i = 0; i < classArray.length; i++)
             classArray[i] = joinPoint.getArgs()[i].getClass();

         return
             proxyFactory
                 .getProxy()
                 .getClass()
                 .getDeclaredMethod(joinPoint.getSignature().getName(), classArray)
                 .invoke(proxyFactory.getProxy(), joinPoint.getArgs());
     }

}