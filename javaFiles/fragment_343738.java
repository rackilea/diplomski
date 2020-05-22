import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.lang.reflect.Field;

@YourExceptionHandler
@Interceptor
public class YourExceptionInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object handleException(InvocationContext ctx) {

        //logger.debug("hash:{}", System.identityHashCode(this));
        Result returnResult = new Result();

        Field resultField = null;
        Object result = null;
        Class<? extends Object> returnType = ctx.getMethod().getReturnType();

        try
        {
            logger.info("method:{},return type:{}", ctx.getMethod(), 
                ctx.getMethod().getGenericReturnType());
            returnType = ctx.getMethod().getReturnType();
            result = ctx.proceed(); // this invoke your service
        }
        catch ( UsernameInvalidException e )
        {
            try
            {
                result = returnType.newInstance();
                resultField = result.getClass().getDeclaredField("result");

                if ( resultField == null )
                {
                    return null;
                }

                returnResult.setResultType(ResultType.ERROR);
                returnResult.setResultCode(e.getErrorCode()); // code you defined
             // error text you set in UsernameInvalidException when thrown
                returnResult.setText(e.getMessage()); 
            }
            catch ( Exception e1 )
            {
                e1.printStackTrace();
            }
        }
        catch ( Exception e ) // catch other unexpected exceptions
        {
            e.printStackTrace();
        }

        try
        {
            if ( resultField != null )
            {
                resultField.setAccessible(true);
                resultField.set(result, returnResult);
            }
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return result;
    }

}