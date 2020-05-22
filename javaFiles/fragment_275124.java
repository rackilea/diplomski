public class RealPayment implements Payment {
   @Inject
   public RealPayment(
      CreditService creditService,
      AuthService authService,
      @Assisted Date startDate,
      @Assisted Money amount) {
     ...
   }
 }