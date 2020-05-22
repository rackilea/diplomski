@Around(value = "@annotation(annotation)")
public Object verifyOtp(final ProceedingJoinPoint jointPoint, final DummyAnnotation  annotation) throws Throwable {

String transactionId = getDummyValue(annotation.dummyParam1(),jointPoint.getArgs());
String otp = getDummyValue(annotation.dummyParam2(),jointPoint.getArgs());

        Boolean otpValid = otpService.verify(transactionId, otp);
        if (otpValid) {
            return jointPoint.proceed();
        }
        else {
            throw new AuthentificationForteException();
        }