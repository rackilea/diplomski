@Aspect
@Component
public class RestCallsExceptionHandlingAspect {

    @AfterThrowing(pointcut = "execution(* eu.mypackage.RestClient.*(..))", throwing = "e")
    public void handle(Exception e) throws Throwable  {
        if (e instanceof RestClientException) {
            if (e instanceof HttpStatusCodeException) {
                if (((HttpStatusCodeException)e).getStatusCode().is4xxClientError()) {
                    throw new TranslatableException(e, ValidationErrorGroup.COMMUNICATION_ERROR, CommonErrorCode.CLIENT_ERROR.name());
                } else {
                    throw new TranslatableException(e, ValidationErrorGroup.COMMUNICATION_ERROR, CommonErrorCode.SERVER_ERROR.name());
                }
            } else {
                throw new TranslatableException(e, ValidationErrorGroup.COMMUNICATION_ERROR, CommonErrorCode.CORE_IO_ERROR.name());
            }
        }
        throw e;
    }
}