public abstract class AbstractHandler implements HandlerInterceptor
{

     @Override
     public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handOb, Exception ex) throws Exception
     {
          if (//check the req type)
          {
             afterCompletionMethod(req, res, handler, ex);
          }
     }

     public abstract void afterCompletionMethod(HttpServletRequest req, HttpServletResponse res, Object handOb, Exception ex) throws Exception;


 }