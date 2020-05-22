@Component
 public class DummyService {

 @DummyAnnotation(dummyParam1="#{args[0]}",dummyParam2="#{args[1]}")
 public void dummy(String otp, String transactionId){

 }
 }